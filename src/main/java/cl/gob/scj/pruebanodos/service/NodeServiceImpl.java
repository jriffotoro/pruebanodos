package cl.gob.scj.pruebanodos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.gob.scj.pruebanodos.dto.NewNodeRequestDTO;
import cl.gob.scj.pruebanodos.dto.NodeDTO;
import cl.gob.scj.pruebanodos.dto.RespuestaJSON;
import cl.gob.scj.pruebanodos.repository.NodeRepository;
import cl.gob.scj.pruebanodos.model.Node;

@Service
public class NodeServiceImpl implements NodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeServiceImpl.class);

    @Autowired
    NodeRepository nodeRepository;

    @Value("${cl.gob.scj.id-nodo-raiz}")
	private String idNodoRaiz;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<RespuestaJSON> addNode(NewNodeRequestDTO newNodeRequestDTO) {
        Optional<Node> optionalNodeParent = nodeRepository.findById(newNodeRequestDTO.getParentId());
        if (!optionalNodeParent.isPresent()) {
            return new ResponseEntity<>(new RespuestaJSON("Los parametros no son correctos", newNodeRequestDTO), HttpStatus.BAD_REQUEST);
        }
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Node node = new Node();
        node.setId(uuidAsString);
        node.setName(newNodeRequestDTO.getName());
        node.setParent(optionalNodeParent.get());
        nodeRepository.save(node);
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setId(node.getId());
        nodeDTO.setName(node.getName());
        nodeDTO.setParentId(optionalNodeParent.get().getId());
        return new ResponseEntity<>(new RespuestaJSON("Operacion exitosa. Se agrega un nodo y se le genera un id", nodeDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespuestaJSON> findNodeById(String id) {
        Optional<Node> optionalNode = nodeRepository.findById(id);
        if (!optionalNode.isPresent()) {
            return new ResponseEntity<>(new RespuestaJSON("El nodo no fue encontrado", null), HttpStatus.NOT_FOUND);
        }
        //LOGGER.debug("{}", optionalNode.get());
        return new ResponseEntity<>(new RespuestaJSON("Operacion exitosa", copyFromNodeToNodeDTO(optionalNode.get()) ), HttpStatus.OK);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<RespuestaJSON> deleteNodeById(String id) {
        if(id.equals(idNodoRaiz)){
            return new ResponseEntity<>(new RespuestaJSON("No es posible borrar el nodo raiz", null), HttpStatus.FORBIDDEN);
        }
        Optional<Node> optionalNode = nodeRepository.findById(id);
        if (!optionalNode.isPresent()) {
            return new ResponseEntity<>(new RespuestaJSON("El nodo no fue encontrado", null), HttpStatus.NOT_FOUND);
        }
        NodeDTO nodeDTO = copyFromNodeToNodeDTO(optionalNode.get());
        nodeRepository.delete(optionalNode.get());
        return new ResponseEntity<>(new RespuestaJSON("Operacion exitosa", nodeDTO), HttpStatus.OK);
    }

    private NodeDTO copyFromNodeToNodeDTO(Node node) {
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setId(node.getId());
        nodeDTO.setName(node.getName());
        nodeDTO.setParentId(node.getParent().getId());
        nodeDTO.setChildrens(copyChildren(node.getChildrens())); // Copia la lista de hijos recursivamente
        return nodeDTO;
    }
    
    private List<NodeDTO> copyChildren(List<Node> children) {
        List<NodeDTO> childrenDTO = new ArrayList<>();
        for (Node child : children) {
            if (!child.getId().equals(idNodoRaiz)) {
                NodeDTO childDTO = copyFromNodeToNodeDTO(child); // Copia cada hijo llamando al método principal
                childrenDTO.add(childDTO);
            }
        }
        return childrenDTO;
    }

}
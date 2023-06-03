package cl.gob.scj.pruebanodos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gob.scj.pruebanodos.dto.RespuestaJSON;
import cl.gob.scj.pruebanodos.dto.NewNodeRequestDTO;
import cl.gob.scj.pruebanodos.service.NodeService;

@RestController
@RequestMapping("/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @PostMapping
    public ResponseEntity<RespuestaJSON> addNode(@Valid @RequestBody NewNodeRequestDTO newNodeRequestDTO) {
        return nodeService.addNode(newNodeRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaJSON> getNodeById(@PathVariable String id) {
        return nodeService.findNodeById(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaJSON> deleteNodeById(@PathVariable String id) {
        return nodeService.deleteNodeById(id);
    }

}
package cl.gob.scj.pruebanodos.service;

import org.springframework.http.ResponseEntity;

import cl.gob.scj.pruebanodos.dto.NewNodeRequestDTO;
import cl.gob.scj.pruebanodos.dto.RespuestaJSON;

public interface NodeService {

    ResponseEntity<RespuestaJSON> addNode(NewNodeRequestDTO newNodeRequestDTO);

    ResponseEntity<RespuestaJSON> findNodeById(String id);

    ResponseEntity<RespuestaJSON> deleteNodeById(String id);
    
}
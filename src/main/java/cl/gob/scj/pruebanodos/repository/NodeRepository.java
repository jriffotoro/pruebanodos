package cl.gob.scj.pruebanodos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cl.gob.scj.pruebanodos.model.Node;

public interface NodeRepository extends CrudRepository<Node, String>  {

    List<Node> findAll();

    @Query("select n from Node n "	
	+ "where n.name = :name")
    Node findByName(@Param("name") String name);
    
}
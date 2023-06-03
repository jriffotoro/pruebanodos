package cl.gob.scj.pruebanodos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name="node")
@ToString
public class Node {
    
    @Id
    private String id;
    private String name;

    //bi-directional many-to-one association to Node
	@ManyToOne
    @JoinColumn(name="parent_id")
    private Node parent;

    //bi-directional one-to-many association to Node
	@OneToMany(mappedBy="parent", cascade = {CascadeType.REMOVE}, fetch=FetchType.LAZY)
    private List<Node> childrens;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildrens() {
        return this.childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }
    
}
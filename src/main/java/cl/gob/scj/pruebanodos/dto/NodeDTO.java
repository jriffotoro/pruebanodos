package cl.gob.scj.pruebanodos.dto;

import java.util.List;

public class NodeDTO {

    private String id;
    private String name;
    private String parentId;
    private List<NodeDTO> childrens;

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

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<NodeDTO> getChildrens() {
        return this.childrens;
    }

    public void setChildrens(List<NodeDTO> childrens) {
        this.childrens = childrens;
    }
    
}
package cl.gob.scj.pruebanodos.dto;

import javax.validation.constraints.NotEmpty;

public class NewNodeRequestDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String parentId;

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

}
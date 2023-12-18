package uz.pdp.appstudentcrud.payload;

import uz.pdp.appstudentcrud.entity.Group;

import java.io.Serializable;

public class GroupDTO implements Serializable {
    private Integer id;
    private String name;

    public GroupDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public GroupDTO(Group group){
        this.id = group.getId();
        this.name = group.getName();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

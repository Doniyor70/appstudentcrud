package uz.pdp.appstudentcrud.entity;

import uz.pdp.appstudentcrud.payload.GroupDTO;

import java.io.Serializable;

public class Group implements Serializable {
    private Integer id;
    private String name;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Group(GroupDTO groupDTO){
        this.id = groupDTO.getId();
        this.name = groupDTO.getName();

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
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

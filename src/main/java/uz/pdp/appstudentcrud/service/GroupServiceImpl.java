package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.payload.GroupDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class GroupServiceImpl implements GroupService{
    public List<GroupDTO> groupDTOS = Collections.synchronizedList(new ArrayList<>());

    private static GroupServiceImpl instance;

    private GroupServiceImpl() {
    }

    public static GroupServiceImpl getInstance() {
        if (Objects.isNull(instance))
            instance = new GroupServiceImpl();

        return instance;
    }
    @Override
    public List<GroupDTO> all() {
        return groupDTOS;
    }

    @Override
    public GroupDTO add(GroupDTO groupDTO) {
        groupDTO.setId(groupDTOS.size() + 1);
        groupDTOS.add(groupDTO);
        return groupDTO;
    }

    @Override
    public GroupDTO edit(Integer id, GroupDTO groupDTO) {
        GroupDTO newGroupDTO = getByIdOrElseThrow(id);
        newGroupDTO.setName(groupDTO.getName());

        return newGroupDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return groupDTOS.remove(getByIdOrElseThrow(id));
    }

    @Override
    public GroupDTO getByIdOrElseThrow(Integer id) {
        return groupDTOS.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}

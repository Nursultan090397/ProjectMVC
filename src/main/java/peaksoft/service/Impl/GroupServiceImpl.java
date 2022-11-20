package peaksoft.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Group;
import peaksoft.repository.GroupRepository;
import peaksoft.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.getAllGroup();
    }

    @Override
    public void addGroup(Long id, Group group) {
        groupRepository.addGroup(id,group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.getGroupById(id);
    }

    @Override
    public void updateGroup(Group group, Long id) {
        groupRepository.updateGroup(group,id);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteGroup(id);
    }

    @Override
    public void assignGroup(Long courseId, Long groupId) {
        groupRepository.assignGroup(courseId, groupId);
    }
}
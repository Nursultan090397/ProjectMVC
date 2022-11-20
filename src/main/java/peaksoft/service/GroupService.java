package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();

    void addGroup(Long id, Group group);

    Group getGroupById(Long id);

    void updateGroup(Group group, Long id);

    void deleteGroup(Long id);

    void assignGroup(Long courseId, Long groupId);
}
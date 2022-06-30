package ru.levelup.studentdb.service;

import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;

import java.util.List;

public interface GroupsService {
    void save(Group group);

    List<Group> findAll();

    void addStudent(Group group, Student student);

    Group findOrCreateGroup(List<Group> groups, String groupName);
}

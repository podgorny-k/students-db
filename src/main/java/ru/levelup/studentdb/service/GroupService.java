package ru.levelup.studentdb.service;

import ru.levelup.studentdb.model.Group;

import java.util.List;

public interface GroupService {
    void save(Group group);
    List<Group> findAll();
}

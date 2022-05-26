package ru.levelup.studentdb.service;

import ru.levelup.studentdb.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    void save(Group group);
    List<Group> findAll();

    Optional<Group> findByName(String groupName);
}

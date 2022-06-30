package ru.levelup.studentdb.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GroupsServiceInMemoryImpl implements GroupsService {

    private final List<Group> groups = new ArrayList<>();

    @Override
    public void save(Group group) {
        if (groups.contains(group)) System.out.println(group.getName() + " group already exist");
        else groups.add(group);
    }

    @Override
    public List<Group> findAll() {
        return Collections.unmodifiableList(groups);
    }

    @Override
    public void addStudent(Group group, Student student) {
        group.addStudent(student);
    }

    @Override
    public Group findOrCreateGroup(List<Group> groups, String groupName) {
        Group requiredGroup;
        Optional<Group> filteredGroup = groups.stream()
                .filter(group -> group.getName().equalsIgnoreCase(groupName))
                .findFirst();
        if (filteredGroup.isPresent()) {
            requiredGroup = filteredGroup.get();
        } else {
            requiredGroup = new Group(groupName, new ArrayList<>());
            this.save(requiredGroup);
        }
        return requiredGroup;
    }
}
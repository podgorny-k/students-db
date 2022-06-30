package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.GroupsService;

import java.util.ArrayList;

@Component("create groupAction")
@Scope("prototype")
@RequiredArgsConstructor
public class CreateGroupAction implements Action {

    private final GroupsService groupsService;

    private String groupName;

    @Override
    public void setParams(String... param) {
        this.groupName = param[0];
    }

    @Override
    public void execute() {
        Group group = new Group(groupName, new ArrayList<>());
        groupsService.save(group);
    }
}
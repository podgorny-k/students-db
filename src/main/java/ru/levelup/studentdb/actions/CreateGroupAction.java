package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

@Component("createGroupAction")
@Scope("prototype")
@RequiredArgsConstructor
public class CreateGroupAction implements Action {

    private String groupName;

    private final GroupService groupService;

    @Override
    public void setParams(String... param) {
        this.groupName = param[0];
    }

    @Override
    public void execute() {
        Group group = new Group(groupName);
        groupService.save(group);
    }

}

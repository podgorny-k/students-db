package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.GroupsService;
import ru.levelup.studentdb.service.StudentsService;

@Component("add studentAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddStudentToGroupAction implements Action {

    private final StudentsService studentsService;
    private final GroupsService groupsService;

    private String firstName;
    private String lastName;
    private String groupName;

    @Override
    public void setParams(String... param) {
        this.firstName = param[0];
        this.lastName = param[1];
        this.groupName = param[3];
    }

    @Override
    public void execute() {
        var students = studentsService.findAll();
        var groups = groupsService.findAll();

        var student = studentsService.findOrCreateStudent(students, firstName, lastName);
        var group = groupsService.findOrCreateGroup(groups, groupName);

        groupsService.addStudent(group, student);
    }
}
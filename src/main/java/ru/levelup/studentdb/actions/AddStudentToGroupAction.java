package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.Optional;

@Component("addStudentAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddStudentToGroupAction implements Action {

    private final StudentsService studentsService;
    private final GroupService groupService;

    private String firstName;
    private String lastName;
    private String groupName;

    @Override
    public void setParams(String... param) {
        if (param.length != 3) {
            System.out.println("Use \"add student <FirstName> <LastName> <Group> syntax\"");
            return;
        }
        firstName = param[0];
        lastName = param[1];
        groupName = param[2];
    }

    @Override
    @Transactional
    public void execute() {
        Optional<Group> groupOp = groupService.findByName(groupName);
        Optional<Student> studentOp = studentsService.findByFirstAndLastName(firstName, lastName);

        if (!groupOp.isPresent()) {
            System.out.println("Group doesn't exist");
            return;
        }

        if (!studentOp.isPresent()) {
            System.out.println("Student doesn't exist");
            return;
        }

        Group group = groupOp.get();
        Student student = studentOp.get();

        group.getStudents().add(student);
        student.setGroup(group);
    }
}

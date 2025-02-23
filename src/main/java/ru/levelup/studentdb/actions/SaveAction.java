package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.GroupsService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;

@Component("save dbAction")
@Scope("prototype")
@RequiredArgsConstructor
public class SaveAction implements Action {

    private final DaoService<Student> studentDaoService;
    private final DaoService<Group> groupDaoService;
    private final StudentsService studentsService;
    private final GroupsService groupService;

    @Override
    public void setParams(String... param) {
    }

    @Override
    public void execute() {
        List<Student> allStudents = studentsService.findAll();
        allStudents.forEach(studentDaoService::save);

        List<Group> allGroups = groupService.findAll();
        allGroups.forEach(groupDaoService::save);

        System.out.println("Save DB");
    }
}
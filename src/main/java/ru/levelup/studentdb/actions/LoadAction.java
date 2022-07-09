package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.GroupsService;
import ru.levelup.studentdb.service.StudentsService;

@Component("load dbAction")
@Scope("prototype")
@RequiredArgsConstructor
public class LoadAction implements Action {

    private final DaoService<Student> studentDaoService;
    private final DaoService<Group> groupDaoService;
    private final StudentsService studentsService;
    private final GroupsService groupsService;

    @Override
    public void setParams(String... param) {
    }

    @Override
    public void execute() {
        studentDaoService.findAll().forEach(studentsService::save);
        groupDaoService.findAll().forEach(groupsService::save);
    }
}
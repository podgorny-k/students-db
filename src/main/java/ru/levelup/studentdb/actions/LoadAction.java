package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.repo.GroupRepo;
import ru.levelup.studentdb.repo.StudentsRepo;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

@Component("loadAction")
@Scope("prototype")
@RequiredArgsConstructor
public class LoadAction implements Action {

    private final StudentsService studentsService;
    private final GroupService groupService;

    private final StudentsRepo studentsRepo;
    private final GroupRepo groupRepo;

    @Override
    public void setParams(String... param) {

    }

    @Override
    @Transactional
    public void execute() {
        studentsRepo.findAll().forEach(studentsService::save);
//        var student = studentsRepo.findAllByFirstNameLike("Alex%");
//        var student = studentsRepo.findAlex();
//        var student = studentsRepo.findStudentsInGroup("A101");
//        studentsRepo.renameStudentById(4026L, "Aleksandr");
        groupRepo.findAll().forEach(groupService::save);
    }
}

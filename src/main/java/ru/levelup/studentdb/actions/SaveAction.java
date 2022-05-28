package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.repo.GroupRepo;
import ru.levelup.studentdb.repo.StudentsRepo;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;

@Component("saveAction")
@Scope("prototype")
@RequiredArgsConstructor
public class SaveAction implements Action {

    private final StudentsService studentsService;
    private final StudentsRepo studentsRepo;
    private final GroupRepo groupRepo;

    @Override
    public void setParams(String... param) {

    }

    @Override
    @Transactional
    public void execute() {
        List<Student> allStudents = studentsService.findAll();
        allStudents.forEach(student -> {
            if (student.getGroup() != null) {
                groupRepo.save(student.getGroup());
            }
            Student s = studentsRepo.save(student);
        });

        System.out.println("Saved to DB");
    }
}

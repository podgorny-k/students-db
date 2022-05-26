package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;

@Component("saveAction")
@Scope("prototype")
@RequiredArgsConstructor
public class SaveAction implements Action {

    private final StudentsService studentsService;
    private final DaoService<Student> studentDaoService;

    @Override
    public void setParams(String... param) {

    }

    @Override
    public void execute() {
        List<Student> allStudents = studentsService.findAll();
        allStudents.forEach(student -> {
            Student s = studentDaoService.save(student);
        });

        System.out.println("Saved to DB");
    }
}

package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component("list studentsAction")
@Scope("prototype")
@RequiredArgsConstructor
public class ListStudentsAction implements Action {

    private final StudentsService studentsService;

    @Override
    public void setParams(String... param) {
    }

    @Override
    public void execute() {
        List<Student> students = studentsService.findAll();

        if (students.isEmpty()) {
            System.out.println("Students list is empty");
        } else {
            AtomicInteger index = new AtomicInteger(1);
            System.out.println("List of students:");
            students.forEach(student -> System.out.println(index.getAndIncrement() + ". " + student.getFullName()));
        }
    }
}
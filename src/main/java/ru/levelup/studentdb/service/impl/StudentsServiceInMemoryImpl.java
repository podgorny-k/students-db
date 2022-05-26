package ru.levelup.studentdb.service.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceInMemoryImpl implements StudentsService {

    @Getter
    private int counter;
    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        counter++;

        findByFirstAndLastName(student.getFirstName(), student.getLastName()).ifPresentOrElse(
                s -> System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " already exists"),
                () -> students.add(student)
        );
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public Optional<Student> findByFirstAndLastName(String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName))
                .filter(student -> student.getLastName().equals(lastName))
                .findFirst();
    }
}

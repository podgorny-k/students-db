package ru.levelup.studentdb.service.impl;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.StudentsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static ru.levelup.studentdb.bootstrap.Bootstrap.SPACE;

@Service
public class StudentsServiceInMemoryImpl implements StudentsService {

    @Getter
    private int counter;
    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        counter++;
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public Student findOrCreateStudent(List<Student> students, String firstName, String lastName) {
        Student requiredStudent;
        Optional<Student> findedStudent = students.stream()
                .filter(student -> student.getFullName().equalsIgnoreCase(firstName + SPACE + lastName))
                .findFirst();
        if (findedStudent.isPresent()) {
            requiredStudent = findedStudent.get();
        } else {
            requiredStudent = new Student(firstName, lastName);
            this.save(requiredStudent);
        }
        return requiredStudent;
    }
}

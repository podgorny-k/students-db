package ru.levelup.studentdb.service;

import ru.levelup.studentdb.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentsService {
    void save(Student student);
    List<Student> findAll();

    Optional<Student> findByFirstAndLastName(String firstName, String lastName);
}

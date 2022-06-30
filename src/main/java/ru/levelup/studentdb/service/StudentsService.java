package ru.levelup.studentdb.service;

import ru.levelup.studentdb.model.Student;

import java.util.List;

public interface StudentsService {
    void save(Student student);
    List<Student> findAll();

    Student findOrCreateStudent(List<Student> students, String firstName, String lastName);
}

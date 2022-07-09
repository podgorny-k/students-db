package ru.levelup.studentdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Group {
    private Long id;
    private final String name;
    private List<Student> students = new ArrayList<>();

    public Group(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
package ru.levelup.studentdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Group {
    private final String name;
    private List<Student> students;

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<String> getFullNamesStudents() {
        return students.stream().map(Student::getFullName).collect(Collectors.toList());
    }
}
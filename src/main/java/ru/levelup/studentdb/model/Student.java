package ru.levelup.studentdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static ru.levelup.studentdb.bootstrap.Bootstrap.SPACE;

@Data
@AllArgsConstructor
public class Student {
    private Long id;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + SPACE + this.lastName;
    }
}

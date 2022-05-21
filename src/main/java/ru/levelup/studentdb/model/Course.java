package ru.levelup.studentdb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "courses", schema = "edu_schema")
public class Course {

    @Id
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}

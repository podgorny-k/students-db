package ru.levelup.studentdb.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.levelup.studentdb.model.Student;

import java.util.List;

public interface StudentsRepo extends CrudRepository<Student, Long> {

}

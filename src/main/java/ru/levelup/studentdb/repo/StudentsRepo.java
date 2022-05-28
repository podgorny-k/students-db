package ru.levelup.studentdb.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.levelup.studentdb.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentsRepo extends CrudRepository<Student, Long> {

    Optional<Student> findFirstByFirstName(String firstName);

    List<Student> findAllByFirstNameLike(String firstNamePrefix);

    @Query("select s from Student s where s.firstName like 'Alex%'")
    List<Student> findAlex();

    @Query("select s from Student s where s.group.name = :group")
    List<Student> findStudentsInGroup(@Param("group") String groupName);

    @Query("update Student s set s.firstName = :firstName where s.id = :id")
    @Modifying
    void renameStudentById(@Param("id") Long id, @Param("firstName") String newName);
}

package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentsJpaDaoImpl implements DaoService<Student> {

    @PersistenceContext
    private final EntityManager em;

    @Override
    @Transactional
    public Student save(Student data) {
        if (data.getId() == null) {
            em.persist(data);
            return data;
        } else {
            return em.merge(data);
        }
    }

    @Override
    public Collection<Student> findAll() {
        Query query = em.createQuery("select s from Student s");
        return query.getResultList();
    }
}

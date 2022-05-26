package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
//@RequiredArgsConstructor
public class GroupJpaDaoImpl implements DaoService<Group> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Group save(Group data) {
        if (data.getId() == null) {
            em.persist(data);
            return data;
        } else {
            return em.merge(data);
        }
    }

    @Override
    public Collection<Group> findAll() {
        Query query = em.createQuery("select g from Group g");
        return query.getResultList();
    }

}

package ru.levelup.studentdb.service;

import java.util.Collection;

public interface DaoService<T> {
    T save(T data);
    Collection<T> findAll();
}

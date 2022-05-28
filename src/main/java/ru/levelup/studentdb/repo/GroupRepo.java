package ru.levelup.studentdb.repo;

import org.springframework.data.repository.CrudRepository;
import ru.levelup.studentdb.model.Group;

public interface GroupRepo extends CrudRepository<Group, Long> {
}

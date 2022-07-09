package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.DaoService;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GroupsJdbcDaoImpl implements DaoService<Group> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(Group group) {
        String insertSql = "insert into edu_schema.groups (name) values (:name)";
        String updateSql = "update edu_schema.groups set name = :name where id = :id";

        if (group.getId() == null) {
            jdbcTemplate.update(insertSql, Map.of(
                    "name", group.getName()
            ));
        } else {
            jdbcTemplate.update(updateSql, Map.of(
                    "id", group.getId(),
                    "name", group.getName()
            ));
        }
    }

    @Override
    public List<Group> findAll() {
        String sql = "select id, name from edu_schema.groups";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Group(
                rs.getLong(1),
                rs.getString(2)
        ));
    }
}

package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.GroupsService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component("list groupsAction")
@Scope("prototype")
@RequiredArgsConstructor
public class ListGroupsAction implements Action {

    private final GroupsService groupsService;

    @Override
    public void setParams(String... param) {
    }

    @Override
    public void execute() {
        List<Group> groups = groupsService.findAll();

        if (groups.isEmpty()) {
            System.out.println("Groups list is empty");
        } else {
            AtomicInteger index = new AtomicInteger(1);
            System.out.println("List of groups:");
            if (groups.stream().anyMatch(group -> group.getStudents().isEmpty())) {
                groups.forEach(group -> System.out.println(index.getAndIncrement() + ". " + group.getName()));
            } else {
                groups.forEach(group -> System.out.println(index.getAndIncrement() + ". " + group.getName()
                        + ". Students: " + group.getFullNamesStudents()));
            }
        }
    }
}
package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.ApplicationContextHolder;

import java.util.Arrays;

@Component("createAction")
@Scope("prototype")
@RequiredArgsConstructor
public class CreateAction extends CmdAction {

    @Override
    protected String getCommand() {
        return "create";
    }
}

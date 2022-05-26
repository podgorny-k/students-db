package ru.levelup.studentdb.actions;

import org.springframework.context.ApplicationContext;
import ru.levelup.studentdb.service.ApplicationContextHolder;

import java.util.Arrays;

public abstract class CmdAction implements Action {

    private String entity;
    private String[] params;

    @Override
    public void setParams(String... params) {
        if (params.length == 0) {
            System.out.println("Unknown entity to create");
            return;
        }

        this.entity = params[0];
        this.params = Arrays.copyOfRange(params, 1, params.length);
    }

    @Override
    public void execute() {
        ApplicationContext ctx = ApplicationContextHolder.getContext();

        Object actionObject = ctx.getBean(getCommand() + capitalize(entity) + "Action");
        if (actionObject instanceof Action) {
            Action action = (Action) actionObject;
            action.setParams(params);
            action.execute();
        } else {
            System.out.println("Unknown action");
        }
    }

    protected abstract String getCommand();

    // CREaTe ->> Create
    private String capitalize(String str) {
        if (str.length() == 0) {
            return str;
        }
        String result = str.substring(0, 1).toUpperCase();
        if (str.length() > 1) {
            result += str.substring(1).toLowerCase();
        }
        return result;
    }

}

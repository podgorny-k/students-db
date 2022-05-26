package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("addAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddAction extends CmdAction {
    @Override
    protected String getCommand() {
        return "add";
    }
}

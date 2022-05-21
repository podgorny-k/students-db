package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.actions.Action;
import ru.levelup.studentdb.actions.CreateStudentAction;
import ru.levelup.studentdb.actions.ListStudentsAction;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.CommandProcessor;
import ru.levelup.studentdb.service.StudentsService;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandProcessorImpl implements CommandProcessor, ApplicationContextAware {

    private final StudentsService studentsService;

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public void process(String cmd, String... args) {
        Object actionObject = ctx.getBean(cmd + "Action");
        if (actionObject instanceof Action) {
            Action action = (Action) actionObject;
            if (args.length > 1) {
                action.setParams(Arrays.copyOfRange(args, 0, args.length));
            }
            action.execute();
        } else {
            System.out.println("Unknown");
        }

//        if ("create".equals(cmd)) {
//            if ("student".equals(args[0])) {
//                // create student object
//
//                Action action = ctx.getBean(CreateStudentAction.class);
//                action.setParams(Arrays.copyOfRange(args, 1, args.length));
//                action.execute();
//
//                System.out.println("Student created");
//
//            } else if ("group".equals(args[0])) {
//                // create group
//            } else {
//                System.out.println("Unknown arg " + args[0]);
//            }
//        } else if ("list".equals(cmd)) {
//            if ("students".equals(args[0])) {
//                // list students
//                Action action = ctx.getBean(ListStudentsAction.class);
//                action.setParams(Arrays.copyOfRange(args, 1, args.length));
//                action.execute();
//            }
//        } else if ("save".equals(cmd)) {
//
//        } else if ("load".equals(cmd)) {
//
//        } else {
//            System.out.println("Unknown command");
//        }
    }
}

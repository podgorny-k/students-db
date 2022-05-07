package ru.levelup.studentdb.actions;

public interface Action {
    void setParams(String... param);
    void execute();
}

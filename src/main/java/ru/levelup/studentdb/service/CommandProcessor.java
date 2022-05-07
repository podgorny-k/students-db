package ru.levelup.studentdb.service;

public interface CommandProcessor {
    void process(String cmd, String... args);
}

package ru.levelup.studentdb.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.CommandProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CommandProcessor processor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please, enter command");

        // create student FirstName LastName
        // list students

        // create group GroupName
        // list groups

        // save
        // load

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        processor.process("load");

        while (true) {
            System.out.print(">");
            line = reader.readLine();
            if (line == null || "exit".equals(line.trim())) {
                break;
            }

            String commandLine = line.trim();
            if (commandLine.isEmpty()) {
                continue;
            }
            String[] tokens = commandLine.split(" ");
            processor.process(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length));
        }

        System.out.println();
    }

}

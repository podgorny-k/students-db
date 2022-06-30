package ru.levelup.studentdb.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.CommandProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CommandProcessor processor;

    public static final String SPACE = " ";

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please, enter command");
        System.out.print(">");

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!(line = reader.readLine()).equals("exit")) {
            String[] tokens = line.split(SPACE);
            if (tokens.length < 2) System.out.println("Minimum number of arguments: 2");
            else processor.process(tokens[0], tokens[1], Arrays.copyOfRange(tokens, 1, tokens.length));
        }
        System.out.println();
    }
}
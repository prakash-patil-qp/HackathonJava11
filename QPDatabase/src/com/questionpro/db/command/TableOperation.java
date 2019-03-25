package com.questionpro.db.command;

import com.questionpro.db.validator.CommandValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TableOperation {
    CREATE,
    SELECT,
    INSERT;

    public static boolean isValidOperation(String operation) {
        System.out.println("Operation is valid");
        CommandValidator commandValidator = (commandName) -> {
            List<String> operations = Stream.of(TableOperation.values())
                    .map(Enum::name)
                    .collect(Collectors.toList());

            return operations.stream().anyMatch(s -> s.equalsIgnoreCase(commandName));
        };

        return commandValidator.validate(operation);
    }
}

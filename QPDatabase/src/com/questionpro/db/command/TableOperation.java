package com.questionpro.db.command;

import com.questionpro.db.validator.CommandValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TableOperation {
    CREATE(1, "CREATE"),
    UPDATE(2, "UPDATE"),
    SELECT(3, "SELECT"),
    INSERT(4, "INSERT");

    int id;
    String operation;

    TableOperation(int id, String operation) {
        this.id = id;
        this.operation = operation;
    }

    public int getValue() {
        return id;
    }
    public String getType() {
        switch (getValue()){
            case 1:return TableOperation.CREATE.getType();
            case 2: return TableOperation.UPDATE.getType();
            case 3: return TableOperation.SELECT.getType();
            case 4: return TableOperation.INSERT.getType();
            default:return "";
        }
    }


    public static boolean isValidOperation(String operation) {
        CommandValidator commandValidator = (commandName) -> {
            List<String> operations = Stream.of(TableOperation.values())
                    .map(Enum::name)
                    .collect(Collectors.toList());

            return operations.stream().anyMatch(s -> s.equalsIgnoreCase(commandName));
        };

        return commandValidator.validate(operation);
    }
}

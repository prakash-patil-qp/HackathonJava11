package com.questionpro.db.validator;

@FunctionalInterface
public interface CommandValidator {
    boolean validate(String commandName);
}

package com.questionpro.db.handler;

public interface QueryHandler {
    String CREATE = "CREATE";
    String UPDATE = "UPDATE";
    String SELECT = "SELECT";
    String INSERT = "INSERT";

    boolean validate(String query);

    void process(String query);
}

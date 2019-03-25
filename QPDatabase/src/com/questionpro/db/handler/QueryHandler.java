package com.questionpro.db.handler;

import java.io.IOException;

public interface QueryHandler {
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String SELECT = "SELECT";
    public static final String INSERT = "INSERT";
    public boolean validate(String query);
    public void process(String query);
}

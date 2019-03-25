package com.questionpro.db.handler;

public interface QueryHandler {
    public boolean validate(String query);
    public void process(String query);
}

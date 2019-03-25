package com.questionpro.db.handler;

public interface QueryHandler {
    String query = "";
    public boolean validate();
    public void process(String query);
}

package com.questionpro.db.handler;

public class CreateTableHandler implements QueryHandler{
    @Override
    public boolean validate(String query) {
        return false;
    }

    @Override
    public void process(String query) {
        System.out.println("I am create");
    }
}

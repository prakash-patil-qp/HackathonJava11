package com.questionpro.db.handler;

public class SelectTableHandler implements QueryHandler{
    @Override
    public boolean validate(String query) {
        return false;
    }

    @Override
    public void process(String query) {
        if(validate(query)){

        }
        System.out.println("I am select");
    }
}

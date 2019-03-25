package com.questionpro.db.handler;

public class SelectTableHandler implements QueryHandler{
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void process() {
        System.out.println("I am select");
    }
}

package com.questionpro.db.handler;

public class InsertTablehandler implements QueryHandler{
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void process(String query) {
        System.out.println("I am insert");
    }
}

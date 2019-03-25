package com.questionpro.db.handler;

import java.io.IOException;

public interface QueryHandler {
    public boolean validate(String query);
    public void process(String query);
}

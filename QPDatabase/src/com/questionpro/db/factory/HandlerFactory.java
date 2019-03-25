package com.questionpro.db.factory;

import com.questionpro.db.command.TableOperation;
import com.questionpro.db.handler.*;

public class HandlerFactory {
    private static HandlerFactory handlerFactory = new HandlerFactory();

    private HandlerFactory() {
    }

    public static HandlerFactory getInstance() {
        return handlerFactory;
    }

    public QueryHandler getQueryHandler(String operationType) {
        switch (operationType) {
            case QueryHandler.CREATE:
                return new CreateTableHandler();
            case QueryHandler.SELECT:
                return new SelectTableHandler();
            case QueryHandler.INSERT:
                return new InsertTablehandler();
            default:
                return null;
        }
    }
}

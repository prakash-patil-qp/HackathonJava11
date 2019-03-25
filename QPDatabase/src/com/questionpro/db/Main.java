package com.questionpro.db;

import com.questionpro.db.command.TableOperation;
import com.questionpro.db.factory.HandlerFactory;
import com.questionpro.db.handler.CreateTableHandler;
import com.questionpro.db.handler.InsertTablehandler;
import com.questionpro.db.handler.QueryHandler;
import com.questionpro.db.handler.SelectTableHandler;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java 11 hackathon started.......................");
        String query = "";
        Scanner input = new Scanner(System.in, "utf-8");
        do {
            query = "";
            do {
                query += input.nextLine();
            } while (!query.endsWith(";") || query.equalsIgnoreCase("exit"));
            String operation = query.replace(";","").split(" ")[0].toUpperCase();
            if (TableOperation.isValidOperation(operation)) {
                QueryHandler handler = HandlerFactory.getInstance().getQueryHandler(operation);
                handler.process(query);
            }
        } while (!query.equalsIgnoreCase("exit"));
    }
}

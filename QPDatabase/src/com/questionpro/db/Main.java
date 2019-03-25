package com.questionpro.db;

import com.questionpro.db.command.TableOperation;
import com.questionpro.db.factory.HandlerFactory;
import com.questionpro.db.handler.QueryHandler;

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
            String operation = query.replace(";", "").split(" ")[0].toUpperCase();
            if (TableOperation.isValidOperation(operation)) {
                QueryHandler handler = HandlerFactory.getInstance().getQueryHandler(operation);
                if (handler.validate(query)) {
                    handler.process(query);
                } else {
                    System.out.println("Not Valid");
                }
            } else {
                System.out.println("invalid command");
            }
        } while (!query.equalsIgnoreCase("exit"));
    }
}

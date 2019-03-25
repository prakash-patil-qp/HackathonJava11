package com.questionpro.db.handler;

import com.questionpro.db.util.StringUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SelectTableHandler implements QueryHandler {
    @Override
    public boolean validate(String query) {
        return isSQLCorrect(query) && isColumsValid(query);

    }

    private boolean isColumsValid(String query) {
        String[] columns = query.substring(query.indexOf("SELECT") + 6, query.indexOf("FROM")).split(",");
        String tableName = getTableName(query);
        if (columns.length == 1 && columns[0].trim().equals("*")) {
            return true;
        } else {
            List<String> allTableColumns = getAllColums(tableName);
            for (String column : columns) {
                if (!allTableColumns.contains(column)) {
                    return false;
                }

            }
        }
        return true;
    }

    private String getTableName(String query) {
        return query.substring(query.indexOf("FROM") + 4, query.indexOf(";")).trim();
    }

    private List<String> getAllColums(String tableName) {
        try {
            List<String> lines = Files.readAllLines(getPath(tableName));
            return Arrays.asList(lines.get(0).split("\\|"));
        } catch (Exception e) {
            System.out.println("invalid table name");
        }
        return new ArrayList<>();
    }

    private Path getPath(String tableName) {
        return Paths.get("/home/questionpro/HackathonJava11/ActualDatabase/table/" + tableName + "_data.txt");
    }

    private boolean isSQLCorrect(String query) {
        String regex = "SELECT( .+)FROM( .+);";
        return Pattern.matches(regex, query);
    }

    @Override
    public void process(String query) {
        String finalQuery = query.toUpperCase();
        if (validate(finalQuery)) {
            List<String> lines = new ArrayList<>();
            try {
                lines = Files.readAllLines(getPath(getTableName(finalQuery)));
            } catch (Exception e) {
                System.out.println("invalid query");
            }
            lines.stream().forEach(System.out::println);
        }
        System.out.println("I am select");
    }
}

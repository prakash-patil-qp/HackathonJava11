package com.questionpro.db.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.*;

public class InsertTablehandler implements QueryHandler {
    @Override
    public boolean validate(String query) {
        query = query.replaceAll("\\n", " ");
        query = query.replaceAll("\\s", " ");
        String[] tokenArray = query.split(" ");
        if (tokenArray != null && null != tokenArray[0] && "INSERT".equalsIgnoreCase(tokenArray[0]) &&
                null != tokenArray[1] && "INTO".equalsIgnoreCase(tokenArray[1]) && null != tokenArray[2]) {
            if (checkIfTableExists(tokenArray[2])) {
                if (null != tokenArray[3] && tokenArray[3].toUpperCase().startsWith("VALUES(")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void process(String query) {
        query = query.replaceAll("\\n", " ");
        query = query.replaceAll("\\s", " ");
        String[] tokenArray = query.split(" ");
        if (tokenArray != null && null != tokenArray[0] && "INSERT".equalsIgnoreCase(tokenArray[0]) &&
                null != tokenArray[1] && "INTO".equalsIgnoreCase(tokenArray[1]) && null != tokenArray[2]) {
            if (checkIfTableExists(tokenArray[2])) {
                if (null != tokenArray[3] && tokenArray[3].toUpperCase().startsWith("VALUES(")) {
                    String[] values = query.toUpperCase().split("VALUES\\(");
                    if (null != values && null != values[1]) {
                        String[] parameters = values[1].split("\\);");
                        if (null != parameters[0] && !parameters[0].isEmpty()) {
                            String[] actualValuesare = parameters[0].split(",");

                            try {
                                FileWriter fr = new FileWriter("/tmp/" + tokenArray[2] + "_data.txt", true);
                                BufferedWriter br = new BufferedWriter(fr);
                                PrintWriter pr = new PrintWriter(br);
                                pr.println();
                                for (int i = 0; i < actualValuesare.length - 1; i++) {
                                    pr.print(actualValuesare[i]);
                                    pr.print("|");
                                }
                                pr.print(actualValuesare[actualValuesare.length - 1]);

                                pr.close();
                                br.close();
                                fr.close();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }


    public boolean checkIfTableExists(String tableName) {
        File folder = new File("/tmp/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().toUpperCase().equalsIgnoreCase(tableName + "_" + "data.txt")) {
                    return true;
                }
            }
        }
        return false;
    }
}


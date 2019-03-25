package com.questionpro.db.handler;

import java.io.*;

public class CreateTableHandler implements QueryHandler {
    @Override
    public boolean validate(String query) {
        return validateForCreate(query);
    }

    @Override
    public void process(String query) {
        System.out.println("query ---");
        createDirectoryForCREATEOperation();
    }

    private void createDirectoryForCREATEOperation() {

        System.out.println("Ready for create !!");
        Console console =
                System.console();
        String choice = console.readLine();
        if (validateForCreate(choice)) {
            String table_name = extractTableName(choice);
            try {
                FileWriter metadataPath = new FileWriter("/tmp/" + table_name.toUpperCase() + "_metadata.txt");
                FileWriter dataPath = new FileWriter("/tmp/" + table_name.toUpperCase() + "_data.txt");

                String tempDataTypes = choice.substring(choice.indexOf(table_name) + table_name.length() + 1);
                int l = tempDataTypes.length();
                String dataTypes = tempDataTypes.substring(0, l - 2).trim();
                StringBuilder stringBuilderMetaData = new StringBuilder();
                StringBuilder stringBuilderData = new StringBuilder();
                String[] dataType = dataTypes.split(",");
                for (int i = 0; i < dataType.length; i++) {
                    int indexOfDataTypeVariable = dataType[i].trim().indexOf(" ");
                    String dataToBeInsertedInData = dataType[i].trim().substring(indexOfDataTypeVariable + 1);
                    String dataToBeInsertedInMetaData = dataType[i].trim().substring(0, indexOfDataTypeVariable);
                    stringBuilderMetaData.append(dataToBeInsertedInMetaData.trim());
                    stringBuilderMetaData.append("|");
                    stringBuilderData.append(dataToBeInsertedInData.trim());
                    stringBuilderData.append("|");
                }
                metadataPath.write(stringBuilderMetaData.toString());
                metadataPath.close();
                dataPath.write(stringBuilderData.toString());
                dataPath.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean validateForCreate(String command) {
        if (command.contains(";") &&(command.indexOf(";")==command.length()-1)&& command.toUpperCase().contains("CREATE TABLE")) {
            System.out.println("The command seems fine !!---" + command);
            return true;
        }
        System.out.println("Please check the command syntax. :: \nYOUR command is----" + command + "\nStandard Syntax is---- CREATE TABLE TABLE_NAME( varName dataType,  varname dataType);");

        //createDirectoryForCREATEOperation();
        return false;
    }

    private String extractTableName(String command) {

        String temp = command.trim().substring(0, 13);
        String table_temp_name = command.substring(temp.length()).trim();
        String table_Name = table_temp_name.substring(0, table_temp_name.indexOf("("));
        return table_Name.trim();
    }
}

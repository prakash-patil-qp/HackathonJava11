package com.questionpro.db.handler;
import java.io.File;
public class InsertTablehandler implements QueryHandler{
    @Override
    public boolean validate(String query) {

        query = query.replaceAll("\\s", " ");
        query.toUpperCase();

        String[] tokenArray =  query.split("");
        if(tokenArray!=null && tokenArray[0]!=null && "INSERT".equalsIgnoreCase(tokenArray[0]) &&
                tokenArray[1]!=null && "INTO".equalsIgnoreCase(tokenArray[1]) && tokenArray[3]!=null){
            if(checkIfTableExists(tokenArray[3])){
                //Table Exists


            }
        }

        return false;
    }

    @Override
    public void process(String query) {
        System.out.println("I am insert");
        if(!validate(query)){
            System.out.println("Invalid Query for Insert");
        }


    }


    public boolean checkIfTableExists(String tableName){
        File folder = new File("your/path");// Take path from Praveen
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                if(listOfFiles[i].getName().toUpperCase().startsWith(tableName)){
                    return true;
                }
            }
        }
        return false;
    }
}


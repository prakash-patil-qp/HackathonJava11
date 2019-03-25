package com.questionpro.db.handler;
import java.io.File;
public class InsertTablehandler implements QueryHandler{
    @Override
    public boolean validate(String query) {

        query = query.replaceAll("\\n", " ");
        query = query.replaceAll("\\s", " ");

        query.toUpperCase();

        String[] tokenArray =  query.split(" ");
        System.out.println("Token Array After removing white spaces and split with spaces is");
        for(String token:tokenArray){
            System.out.println(token);
        }


        if(tokenArray!=null && null!=tokenArray[0] && "INSERT".equalsIgnoreCase(tokenArray[0]) &&
                null!=tokenArray[1] && "INTO".equalsIgnoreCase(tokenArray[1]) && null!=tokenArray[2] && null!=tokenArray[3] ){
            if(checkIfTableExists(tokenArray[2])){
                //Table Exists

                if(tokenArray[3].toUpperCase().startsWith("VALUES(")){

                    System.out.println("3rd token value is---"+tokenArray[3]);
                    String[] values = query.toUpperCase().split("VALUES\\(");
                    System.out.println("query Starts with VALUES");
                    if(null!=values && null!=values[1] ){
                        String[] parameters = query.split("\\);");
                        if(null!=parameters[0] && !parameters[0].isEmpty()){
                            String[] actualValuesare = parameters[0].split(",");

                        }
                    }
                }
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
        System.out.println("Inside check if table exists");
        File folder = new File("/home/newuser/Documents/Shweta");// Take path from Praveen
        File[] listOfFiles = folder.listFiles();
        System.out.println("Check file Name with tableName"+tableName+"_"+"data.txt");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                if(listOfFiles[i].getName().toUpperCase().equalsIgnoreCase(tableName+"_"+"data.txt")){
                    System.out.println("Check IF checkIfTableExists is passed");
                    return true;
                }
            }
        }
        return false;
    }
}


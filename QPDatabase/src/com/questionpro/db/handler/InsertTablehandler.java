package com.questionpro.db.handler;

public class InsertTablehandler implements QueryHandler{
    @Override
    public boolean validate(String query) {

        query = query.replaceAll("\\s", " ");
        String[] tokenArray =  query.split("");
        if(tokenArray!=null && tokenArray[0]!=null &&  !tokenArray[0].isEmpty() && "INSERT".equalsIgnoreCase(tokenArray[0]) &&
                tokenArray[1]!=null && !tokenArray[1].isEmpty() && "INTO".equalsIgnoreCase(tokenArray[1]) && tokenArray[3]!=null){
            if(checkIfTableExists(tokenArray[3])){

            }
        }

        return false;
    }

    @Override
    public void process(String query) {
        System.out.println("I am insert");
    }


    public boolean checkIfTableExists(String tableName){
        return false;
    }
}


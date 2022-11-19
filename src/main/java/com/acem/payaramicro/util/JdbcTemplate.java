package com.acem.payaramicro.util;

public class JdbcTemplate {

    public static <T> T process(DbExecutionWrapper<T> dbExecutionWrapper){
        //for thread safe capabilities we initialize dbutil inside the method instead of making it into a global variable.
        DbConnector dbConnector = new DbConnector();
        return dbExecutionWrapper.execute(dbConnector);
    }
}

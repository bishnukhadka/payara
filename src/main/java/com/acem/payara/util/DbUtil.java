package com.acem.payara.util;

import com.acem.payara.constant.DbConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtil {

    private Connection connection = null;
    private PreparedStatement statement = null;

    public void connect() throws Exception{
        //Check if the certain drive is present?
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Tell connector to establish a connection using driver specified in the url
        connection = DriverManager.getConnection(DbConstant.URL, DbConstant.USERNAME,DbConstant.PASSWORD);
    }

    public void init(String sql) throws Exception{
        statement = connection.prepareStatement(sql);
    }

    public int executeUpdate() throws Exception{
        return statement.executeUpdate();
    }

    public ResultSet executeQuery() throws Exception{
        return statement.executeQuery();
    }

    public void closeConnection() throws Exception{
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }

    public void mapValues(Object...args) throws  Exception{
        int noOfArgs = args.length;
        for(int i=0;i<noOfArgs;i++){
            statement.setObject(i+1, args[i]);
        }
    }
}

package com.acem.payara.util;

import com.acem.payara.credentials.DbCredentials;
import com.acem.payara.credentials.util.DbCredentialsDotEnvImpl;
import com.acem.payara.mapper.RowMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbConnector {

    private Connection connection = null;
    private PreparedStatement statement = null;

    private DbCredentials dbCredentials;

    public DbConnector(DbCredentials dbCredentials) {
        this.dbCredentials = dbCredentials;
    }

    public DbConnector(){
        this.dbCredentials = new DbCredentialsDotEnvImpl();
    }

    public void connect() throws Exception{
        String url = "jdbc:mysql://" +dbCredentials.getIpAddress() + ":" + dbCredentials.getPort() + "/" + dbCredentials.getName();
        //Check if the certain drive is present?
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Tell connector to establish a connection using driver specified in the url
        connection = DriverManager.getConnection(url, dbCredentials.getUserName(), dbCredentials.getPassword());
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

    public <T> List<T> map(ResultSet resultSet, RowMapper<T> rowMapper) throws Exception{
        List<T> objects = new ArrayList<>();
        while(resultSet.next()){
            T object = rowMapper.map(resultSet);
            objects.add(object);
        }
        return objects;
    }

    public <T> T mapSingle(ResultSet resultSet, RowMapper<T> rowMapper) throws Exception{
        T object = null;
        while(resultSet.next()){
            object = rowMapper.map(resultSet);
            return object;
        }
        return null;
    }



    public <T> List<T> executeAndMap(RowMapper<T> rowMapper) throws Exception{
        return map(executeQuery(),rowMapper);
    }

    public <T> T executeAndMapSingle(RowMapper<T> rowMapper) throws Exception{
        return mapSingle(executeQuery(),rowMapper);
    }

    public void mapValues(Object...args) throws  Exception{
        int noOfArgs = args.length;
        for(int i=0;i<noOfArgs;i++){
            statement.setObject(i+1, args[i]);
        }
    }

    public void connectAndInit(String sql) throws Exception{
        connect();
        init(sql);
    }

    public <T> List<T> execute(String sql, RowMapper<T> rowMapper) throws Exception{
        connectAndInit(sql);
        return executeAndMap(rowMapper);
    }

    public <T> List<T> execute(String sql, RowMapper<T> rowMapper, Object...args) throws Exception{
        connectAndInit(sql);
        mapValues(args);
        return executeAndMap(rowMapper);
    }

    public <T> T executeSingle(String sql, RowMapper<T> rowMapper, Object...args) throws Exception{
        connectAndInit(sql);
        mapValues(args);
        return executeAndMapSingle(rowMapper);
    }

    public int execute(String sql,  Object...args) throws Exception{
        connectAndInit(sql);
        mapValues(args);
        return executeUpdate();
    }


}

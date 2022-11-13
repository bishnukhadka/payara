package com.acem.payara.dao.ipml;

import com.acem.payara.dao.StudentDao;
import com.acem.payara.model.Student;
import com.mysql.cj.protocol.Resultset;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoSqlImpl implements StudentDao {
    @Override
    public Optional<List<Student>> getAll() {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from students";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                students.add(student);
            }
            return Optional.of(students);
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public Optional<Student> getById(Long id) {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from students where id=" +id;
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                return Optional.of(student);
            }
            return Optional.empty();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public Optional<Student> getByEmail(String email) {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from students where emial = '%s'";
            sqlQuery = String.format(sqlQuery,email);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                return Optional.of(student);
            }
            return Optional.empty();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public Optional<Student> getByContactNo(String contactNo) {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from students where CONTACT_NO = '%s'";
            sqlQuery = String.format(sqlQuery,contactNo);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                return Optional.of(student);
            }
            return Optional.empty();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean save(Student student) {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "insert into students(NAME, EMAIL, CONTACT_NO) values('%s','%s', '%s')";
            sqlQuery = String.format(sqlQuery,student.getName(),student.getEmail(),student.getContactNo());
            int rowsEffected = statement.executeUpdate(sqlQuery);
            System.out.println("Rows Effected: "+rowsEffected);
            if (rowsEffected >= 1){
                return true;
            }else
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean update(Student student) {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "update students set NAME= '%s', EMAIL = '%s', CONTACT_NO = '%s' where id = %s";
            sqlQuery = String.format(sqlQuery,student.getName(),student.getEmail(),student.getContactNo(),student.getId());
            int rowsEffected = statement.executeUpdate(sqlQuery);
            System.out.println("Rows Effected: "+rowsEffected);
            if (rowsEffected >= 1){
                return true;
            }else
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public Boolean delete(Long id) {
        Connection connection = null;
        try{
            //Check if the certain drive is present?
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Tell connector to establish a connection using driver specified in the url
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Electron@2020";
            connection = DriverManager.getConnection(url, username,password);

            //get records form database
            Statement statement = connection.createStatement();
            String sqlQuery = "delete from students where id =" + id;
            int rowsEffected = statement.executeUpdate(sqlQuery);
            System.out.println("Rows Effected: "+rowsEffected);
            if (rowsEffected >= 1){
                return true;
            }else
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }finally {
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }
}

package com.acem.payara.dao.ipml;

import com.acem.payara.dao.StudentDao;
import com.acem.payara.mapper.impl.StudentRowMapperImpl;
import com.acem.payara.model.Student;
import com.acem.payara.util.DbUtil;
import com.acem.payara.util.ExceptionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoSqlImpl implements StudentDao {
    @Override
    public Optional<List<Student>> getAll() {
        //for thread safe capabilities we initialize dbutil inside the method instead of making it into a global variable.
        DbUtil dbUtil = new DbUtil();

        return ExceptionHandler.handle( ()-> {
            dbUtil.connect();

            String sqlQuery = "select * from students";
            dbUtil.init(sqlQuery);

            ResultSet resultSet = dbUtil.executeQuery();

            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new StudentRowMapperImpl().map(resultSet);

                students.add(student);
            }
            return Optional.of(students);
        },
                ()-> {
                    ExceptionHandler.handle(dbUtil::closeConnection);
                },
                Optional.empty()
                );

    }

    @Override
    public Optional<Student> getById(Long id) {
        DbUtil dbUtil = new DbUtil();
        try{
            dbUtil.connect();

            //get records form database
            String sqlQuery = "select * from students where id= ?";
            dbUtil.init(sqlQuery);
            dbUtil.mapValues(id);
            ResultSet resultSet = dbUtil.executeQuery();
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new StudentRowMapperImpl().map(resultSet);

                return Optional.of(student);
            }
            return Optional.empty();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            ExceptionHandler.handle(dbUtil::closeConnection);
        }
    }

    @Override
    public Optional<Student> getByEmail(String email) {
        DbUtil dbUtil = new DbUtil();
        try{
           dbUtil.connect();

            //get records form database
            String sqlQuery = "select * from students where email = ?";
            dbUtil.init(sqlQuery);
            dbUtil.mapValues(email);
            ResultSet resultSet = dbUtil.executeQuery();
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new StudentRowMapperImpl().map(resultSet);

                return Optional.of(student);
            }
            return Optional.empty();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            ExceptionHandler.handle(dbUtil::closeConnection);
        }
    }

    @Override
    public Optional<Student> getByContactNo(String contactNo) {
        DbUtil dbUtil = new DbUtil();
        try{
            dbUtil.connect();

            //get records form database
            String sqlQuery = "select * from students where CONTACT_NO = '%s'";
            dbUtil.init(sqlQuery);
            dbUtil.mapValues(contactNo);
            ResultSet resultSet = dbUtil.executeQuery();
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new StudentRowMapperImpl().map(resultSet);
                return Optional.of(student);
            }
            return Optional.empty();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return Optional.empty();
        }finally {
            ExceptionHandler.handle(dbUtil::closeConnection);
        }
    }

    @Override
    public Boolean save(Student student) {
        DbUtil dbUtil = new DbUtil();
        try{
            dbUtil.connect();

            //get records form database
            String sqlQuery = "insert into students(NAME, EMAIL, CONTACT_NO) values(?,?,?)";
            dbUtil.init(sqlQuery);
            dbUtil.mapValues(student.getName(),student.getEmail(),student.getContactNo());

            int rowsEffected = dbUtil.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
            if (rowsEffected >= 1){
                return true;
            }else
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }finally {
            ExceptionHandler.handle(dbUtil::closeConnection);

        }
    }

    @Override
    public Boolean update(Student student) {
        DbUtil dbUtil = new DbUtil();
        try{
            dbUtil.connect();

            //get records form database
            String sqlQuery = "update students set NAME= ?, EMAIL = ?, CONTACT_NO = ? where id = ?";
            dbUtil.init(sqlQuery);
            dbUtil.mapValues(student.getName(),student.getEmail(),student.getContactNo(),student.getId());


            int rowsEffected = dbUtil.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
            if (rowsEffected >= 1){
                return true;
            }else
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }finally {
            ExceptionHandler.handle(dbUtil::closeConnection);
        }
    }

    @Override
    public Boolean delete(Long id) {
        DbUtil dbUtil = new DbUtil();
        try{
            dbUtil.connect();

            //get records form database
            String sqlQuery = "delete from students where id = ?";
            dbUtil.init(sqlQuery);
            dbUtil.mapValues(id);

            int rowsEffected = dbUtil.executeUpdate();
            System.out.println("Rows Effected: "+rowsEffected);
            if (rowsEffected >= 1){
                return true;
            }else
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return false;
        }finally {
            ExceptionHandler.handle(dbUtil::closeConnection);
        }
    }
}

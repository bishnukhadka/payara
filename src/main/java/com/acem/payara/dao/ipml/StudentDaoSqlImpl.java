package com.acem.payara.dao.ipml;

import com.acem.payara.constant.DbQueryConstant;
import com.acem.payara.dao.StudentDao;
import com.acem.payara.mapper.impl.StudentRowMapperImpl;
import com.acem.payara.model.Student;
import com.acem.payara.util.DbConnector;
import com.acem.payara.exception.ExceptionHandler;
import com.acem.payara.util.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class StudentDaoSqlImpl implements StudentDao {
    @Override
    public Optional<List<Student>> getAll() {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () ->  Optional.of(dbConnector.execute(DbQueryConstant.Student.GET_ALL, new StudentRowMapperImpl())),
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                Optional.empty()
        )) ;
    }

    @Override
    public Optional<Student> getById(Long id) {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () ->  Optional.of(dbConnector.executeSingle(DbQueryConstant.Student.GET_BY_ID, new StudentRowMapperImpl(),id)),
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                Optional.empty()
        ));
    }

    @Override
    public Optional<Student> getByEmail(String email) {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () ->  Optional.of(dbConnector.executeSingle(DbQueryConstant.Student.GET_BY_EMAIL, new StudentRowMapperImpl(),email)),
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                Optional.empty()
        ));
    }

    @Override
    public Optional<Student> getByContactNo(String contactNo) {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () ->  Optional.of(dbConnector.executeSingle(DbQueryConstant.Student.GET_BY_CONTACT_NO, new StudentRowMapperImpl(),contactNo)),
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                Optional.empty()
        ));
    }

    @Override
    public Boolean save(Student student) {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () -> dbConnector.execute(DbQueryConstant.Student.SAVE,
                        student.getName(), student.getEmail(), student.getContactNo()) >= 1,
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                false
        ));
    }

    @Override
    public Boolean update(Student student) {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () -> dbConnector.execute(DbQueryConstant.Student.UPDATE,
                        student.getName(),student.getEmail(),student.getContactNo(),student.getId()) >= 1,
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                false
        ));
    }

    @Override
    public Boolean delete(Long id) {
        return JdbcTemplate.process( (dbConnector)-> ExceptionHandler.handle(
                () -> dbConnector.execute(DbQueryConstant.Student.DELETE,
                        id) >= 1,
                () -> ExceptionHandler.handle(dbConnector::closeConnection),
                false
        ));
    }
}

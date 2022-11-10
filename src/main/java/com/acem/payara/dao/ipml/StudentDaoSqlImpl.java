package com.acem.payara.dao.ipml;

import com.acem.payara.dao.StudentDao;
import com.acem.payara.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoSqlImpl implements StudentDao {

    private List<Student> studentList = new ArrayList<>();
    @Override
    public Optional<List<Student>> getAll() {
        return Optional.of(studentList);
    }

    @Override
    public Optional<Student> getById(Long id) {
        return null;
    }

    @Override
    public Optional<Student> getByEmail(String email) {
        return null;
    }

    @Override
    public Optional<Student> getByContactNo(String contactNo) {
        return null;
    }

    @Override
    public Boolean save(Student student) {
        return null;
    }

    @Override
    public Boolean update(Student student) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}

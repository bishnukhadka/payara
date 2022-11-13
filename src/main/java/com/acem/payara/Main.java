package com.acem.payara;

import com.acem.payara.dao.StudentDao;
import com.acem.payara.dao.ipml.StudentDaoMemoryImpl;
import com.acem.payara.dao.ipml.StudentDaoSqlImpl;
import com.acem.payara.model.Student;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoSqlImpl();

        System.out.println("inside main");

        Optional<List<Student>> optionalStudent = studentDao.getAll();

        if(optionalStudent.isPresent()){
            optionalStudent.get().stream().forEach(System.out::println);
        }

    }
}


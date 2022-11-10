package com.acem.payara.dao;

import com.acem.payara.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Optional<List<Student>> getAll();

    Optional<Student> getById(Long id);

    Optional<Student> getByEmail(String email);

    Optional<Student> getByContactNo(String contactNo);

    Boolean save(Student student);

    Boolean update(Student student);

    Boolean delete(Long id);

}

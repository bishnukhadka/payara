package com.acem.payaramicro.service;

import com.acem.payaramicro.model.Student;
import com.acem.payaramicro.response.Response;

import java.util.List;

public interface StudentService {
    Response  getAll();

    Response getById(Long id);

    Response getByEmail(String email);

    Response getByContactNo(String contactNo);

    Response save(Student student);

    Response update(Student student);

    Response delete(Long id);
}

package com.acem.payaramicro.service.impl;

import com.acem.payaramicro.builder.ResponseBuilder;
import com.acem.payaramicro.constant.ResponseMessageConstant;
import com.acem.payaramicro.dao.StudentDao;
import com.acem.payaramicro.dao.ipml.StudentDaoSqlImpl;
import com.acem.payaramicro.model.Student;
import com.acem.payaramicro.response.Response;
import com.acem.payaramicro.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoSqlImpl();

    @Override
    public Response getAll() {
        //get all student records
        Optional<List<Student>> optionalStudentList= studentDao.getAll();
        //if record not empty send the records as json server error response.
        Response responseBody = null;
        if (optionalStudentList.isPresent()){
            List<Student> students =  optionalStudentList.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ALL,students);
        }else{
            responseBody = ResponseBuilder.notFound();
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        //get all student records
        Optional<Student> optionalStudent= studentDao.getById(id);
        //if record not empty send the records as json server error response.
        Response responseBody = null;
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ONE,student);
        }else{
            responseBody = ResponseBuilder.notFound();

        }
        return responseBody;
    }

    @Override
    public Response getByEmail(String email) {
        return null;
    }

    @Override
    public Response getByContactNo(String contactNo) {
        return null;
    }

    @Override
    public Response save(Student student) {
        Boolean isSaved = studentDao.save(student);
        //if record not empty send the records as json server error response.
        Response responseBody = null;
        if (isSaved){
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.SAVE,student);
        }else{
            responseBody = ResponseBuilder.failure(ResponseMessageConstant.Student.NOT_SAVED);

        }
        return responseBody;
    }

    @Override
    public Response update(Student student) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
}

package com.acem.payaramicro.controller;

import com.acem.payaramicro.builder.ResponseBuilder;
import com.acem.payaramicro.constant.RegexConstant;
import com.acem.payaramicro.constant.ResponseMessageConstant;
import com.acem.payaramicro.dao.StudentDao;
import com.acem.payaramicro.dao.ipml.StudentDaoSqlImpl;
import com.acem.payaramicro.exception.ExceptionHandler;
import com.acem.payaramicro.model.Student;
import com.acem.payaramicro.response.Response;
import com.acem.payaramicro.service.StudentService;
import com.acem.payaramicro.service.impl.StudentServiceImpl;
import com.acem.payaramicro.util.JacksonUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class StudentController extends Controller {

    private static final StudentService studentService = new StudentServiceImpl();

    @Override
    public void init() throws ServletException {
        System.out.println("init() method called");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ExceptionHandler.handleWithFallback(
                () -> {
                    String url = request.getRequestURL().toString();
                    System.out.println(url);
                    String[] urlTokenized = url.split("/");
                    String id = urlTokenized[urlTokenized.length - 1];
                    Response responseBody = null;
                    if (id.matches(RegexConstant.isNumber)) {
                        responseBody = studentService.getById(Long.parseLong(id));
                    } else {
                        responseBody = studentService.getAll();
                    }

                    buildResponse(response, responseBody);
                },
                () -> buildResponse(response, ResponseBuilder.serverError())
        );
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExceptionHandler.handleWithFallback(
                () -> {
                    //to save we need name, email and contactNo
                    System.out.println("doPost() called");
                    ServletInputStream servletInputStream = request.getInputStream();
                    Student student = JacksonUtil.toObject(servletInputStream, Student.class);
                    Response responseBody = studentService.save(student);
                    buildResponse(response, responseBody);
                },
                () -> buildResponse(response, ResponseBuilder.serverError())
        );
    }
}

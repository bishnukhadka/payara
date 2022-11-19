package com.acem.payaramicro.constant;

public interface ResponseMessageConstant {

    interface Student{
        String ONE = "Student fetched successfully";
        String ALL = "Students fetched successfully";
        String NOT_FOUND ="Students not found";
        String SAVE ="Students saved.";
        String NOT_SAVED ="Students not saved.";
    }

    String SERVER_ERROR = "Server Error";
}

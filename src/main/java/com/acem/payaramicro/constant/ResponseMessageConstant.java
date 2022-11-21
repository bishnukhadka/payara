package com.acem.payaramicro.constant;

public interface ResponseMessageConstant {

    interface Student{
        String ONE = "Student fetched successfully";
        String ALL = "Students fetched successfully";
        String NOT_FOUND ="Students not found";
        String SAVE ="Students saved.";
        String NOT_SAVED = "Students not saved.";
        String UPDATED = "Students updated successfully";
        String NOT_UPDATED = "Students not updated.";
        String DELETED = "Students deleted successfully";
        String NOT_DELETED = "Students not deleted.";
    }

    String SERVER_ERROR = "Server Error";
    String INVALID_PATH = "Invalid Path";
}

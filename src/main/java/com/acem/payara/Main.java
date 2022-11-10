package com.acem.payara;

import com.acem.payara.dao.StudentDao;
import com.acem.payara.dao.ipml.StudentDaoMemoryImpl;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoMemoryImpl();

        System.out.println("inside main");
    }
}


package com.acem.payaramicro.controller;

import com.acem.payaramicro.response.Response;
import com.acem.payaramicro.util.JacksonUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Controller extends HttpServlet {
    private static final String APPLICATION_JSON = "application/json";

    protected void buildResponse(HttpServletResponse response, Response responseBody) throws IOException {
        //get writer
        PrintWriter writer = response.getWriter();
        response.setContentType(APPLICATION_JSON);
        response.setStatus(responseBody.getStatusCode());
        writer.write(JacksonUtil.toJson(responseBody));
    }
    protected void buildResponse(HttpServletResponse response, int statusCode) throws IOException {
        //get writer
        PrintWriter writer = response.getWriter();
        response.setContentType(APPLICATION_JSON);
        response.setStatus(statusCode);
    }
}

package com.acem.payaramicro.exception;

import com.acem.payaramicro.exception.wrapper.CodeWrapper;
import com.acem.payaramicro.exception.wrapper.ReturnableCodeWrapper;

public class ExceptionHandler {

    public static void handle(CodeWrapper codeWrapper){
        try{
            codeWrapper.execute();
        }catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public static void handle(CodeWrapper tryCodeWrapper, CodeWrapper finallyCodeWrapper){
        try{
            tryCodeWrapper.execute();
        }catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }finally{
            try{
                finallyCodeWrapper.execute();
            }catch (Exception ex){
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    public static void handleWithFallback(CodeWrapper tryCodeWrapper, CodeWrapper catchCodeWrapper){
        try{
            tryCodeWrapper.execute();
        }catch (Exception e){
            try{
                catchCodeWrapper.execute();
                System.out.println(e.getMessage());
            }catch (Exception ex){
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    public static <T> T handle(ReturnableCodeWrapper<T> tryCodeWrapper, CodeWrapper finallyCodeWrapper, T fallBackObject){
        try{
            return tryCodeWrapper.execute();
        }catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return fallBackObject;
        }finally{
            try{
                finallyCodeWrapper.execute();
            }catch (Exception ex){
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    public <T> T handle(ReturnableCodeWrapper<T> returnableCodeWrapper){
        try{
            return returnableCodeWrapper.execute();
        }catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return null;
        }
    }

    public <T> T handle(ReturnableCodeWrapper<T> returnableCodeWrapper, T fallBackObject){
        try{
            return returnableCodeWrapper.execute();
        }catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return fallBackObject;
        }
    }

    public static <T> T handleReturnableWithFallBack(ReturnableCodeWrapper<T> returnableStatementWrapper, ReturnableCodeWrapper<T> fallbackWrapper) {
        try {
            return returnableStatementWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            try {
                return fallbackWrapper.execute();
            } catch (Exception ex2) {
                System.out.println("Exception: " + ex2);
                return null;
            }
        }
    }
}

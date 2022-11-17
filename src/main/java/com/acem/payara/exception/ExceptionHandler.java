package com.acem.payara.exception;

import com.acem.payara.exception.wrapper.CodeWrapper;
import com.acem.payara.exception.wrapper.ReturnableCodeWrapper;

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

}

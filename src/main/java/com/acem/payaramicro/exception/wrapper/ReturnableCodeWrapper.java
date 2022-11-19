package com.acem.payaramicro.exception.wrapper;

@FunctionalInterface
public interface ReturnableCodeWrapper<T>{
    T execute() throws Exception;
}

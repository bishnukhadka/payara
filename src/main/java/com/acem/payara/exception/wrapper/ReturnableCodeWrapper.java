package com.acem.payara.exception.wrapper;

@FunctionalInterface
public interface ReturnableCodeWrapper<T>{
    T execute() throws Exception;
}

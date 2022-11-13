package com.acem.payara.util;

@FunctionalInterface
public interface ReturnableCodeWrapper<T>{
    T execute() throws Exception;
}

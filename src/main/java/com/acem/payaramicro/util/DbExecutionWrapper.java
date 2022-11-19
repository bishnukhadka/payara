package com.acem.payaramicro.util;

public interface DbExecutionWrapper<T> {
    T execute(DbConnector dbConnector);
}

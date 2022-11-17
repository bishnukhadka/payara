package com.acem.payara.util;

public interface DbExecutionWrapper<T> {
    T execute(DbConnector dbConnector);
}

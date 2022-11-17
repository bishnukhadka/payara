package com.acem.payara.exception.wrapper;

@FunctionalInterface
public interface CodeWrapper {
    void execute() throws Exception;
}

package com.acem.payara.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws Exception;
}

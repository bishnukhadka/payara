package com.acem.payaramicro.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws Exception;
}

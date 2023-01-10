package com.cactusli.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * sql行转换
 * Created by cactusli on 2023/1/3 16:39
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws SQLException;

}

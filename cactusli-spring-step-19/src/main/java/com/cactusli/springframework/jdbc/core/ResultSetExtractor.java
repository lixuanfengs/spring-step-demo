package com.cactusli.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cactusli on 2023/1/3 16:38
 */
public interface ResultSetExtractor<T> {

    T extractData(ResultSet rs) throws SQLException;

}

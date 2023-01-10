package com.cactusli.springframework.jdbc.core;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cactusli on 2023/1/3 16:38
 */
public interface StatementCallback<T> {

    T doInStatement(Statement statement) throws SQLException;

}

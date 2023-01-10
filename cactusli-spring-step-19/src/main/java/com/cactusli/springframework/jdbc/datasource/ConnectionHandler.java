package com.cactusli.springframework.jdbc.datasource;

import java.sql.Connection;

/**
 * Created by cactusli on 2023/1/3 16:33
 */
public interface ConnectionHandler {

    Connection getConnection();

    default void releaseConnection(Connection con) {

    }
}

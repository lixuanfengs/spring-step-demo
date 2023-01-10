package com.cactusli.springframework.jdbc;

/**
 * Created by cactusli on 2023/1/3 16:29
 */
public class UncategorizedSQLException extends RuntimeException {

    public UncategorizedSQLException(String message) {
        super(message);
    }

    public UncategorizedSQLException(String task,String sql, Throwable cause) {
        super(sql, cause);
    }

}

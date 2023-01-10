package com.cactusli.springframework.tx.transaction;

/**
 * Created by cactusli on 2023/1/5 16:15
 */
public class TransactionException extends RuntimeException {

    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }

}

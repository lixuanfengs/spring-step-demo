package com.cactusli.springframework.tx.transaction;

/**
 * Created by cactusli on 2023/1/5 16:34
 */
public class NestedTransactionNotSupportedException extends CannotCreateTransactionException {

    public NestedTransactionNotSupportedException(String message) {
        super(message);
    }

    public NestedTransactionNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}

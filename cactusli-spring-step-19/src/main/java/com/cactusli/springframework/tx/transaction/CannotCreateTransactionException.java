package com.cactusli.springframework.tx.transaction;

/**
 * Created by cactusli on 2023/1/5 16:34
 */
public class CannotCreateTransactionException extends TransactionException {
    public CannotCreateTransactionException(String message) {
        super(message);
    }

    public CannotCreateTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

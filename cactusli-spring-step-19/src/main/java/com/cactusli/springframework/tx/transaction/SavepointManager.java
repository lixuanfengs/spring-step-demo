package com.cactusli.springframework.tx.transaction;

/**
 * Created by cactusli on 2023/1/5 16:15
 */
public interface SavepointManager {


    Object createSavepoint() throws TransactionException;

    void rollbackToSavepoint(Object savepoint) throws TransactionException;

    void releaseSavepoint(Object savepoint) throws TransactionException;

}

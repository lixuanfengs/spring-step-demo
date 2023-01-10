package com.cactusli.springframework.tx.transaction;

/**
 * Created by cactusli on 2023/1/5 16:45
 */
public interface PlatformTransactionManager {

    TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;

    void commit(TransactionStatus status) throws TransactionException;

    void rollback(TransactionStatus status) throws TransactionException;

}

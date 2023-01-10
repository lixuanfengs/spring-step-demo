package com.cactusli.springframework.tx.transaction.support;

import com.cactusli.springframework.tx.transaction.interceptor.AbstractTransactionStatus;

/**
 * Created by cactusli on 2023/1/5 16:44
 */
public class DefaultTransactionStatus extends AbstractTransactionStatus {

    private final Object transaction;

    private final boolean newTransaction;


    public DefaultTransactionStatus(Object transaction, boolean newTransaction) {

        this.transaction = transaction;
        this.newTransaction = newTransaction;
    }

    public Object getTransaction() {
        return transaction;
    }

    public boolean hasTransaction() {
        return this.transaction != null;
    }

    @Override
    public boolean isNewTransaction() {
        return hasTransaction() && this.newTransaction;
    }
}

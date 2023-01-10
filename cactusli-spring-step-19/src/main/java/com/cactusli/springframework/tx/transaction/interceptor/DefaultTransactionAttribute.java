package com.cactusli.springframework.tx.transaction.interceptor;

import com.cactusli.springframework.tx.transaction.support.DefaultTransactionDefinition;

/**
 * Created by cactusli on 2023/1/5 15:03
 */
public class DefaultTransactionAttribute extends DefaultTransactionDefinition implements TransactionAttribute {

    public DefaultTransactionAttribute() {
        super();
    }

    @Override
    public boolean rollbackOn(Throwable ex) {
        return (ex instanceof RuntimeException || ex instanceof Error);
    }

    @Override
    public String toString() {
        return "DefaultTransactionAttribute{}";
    }
}

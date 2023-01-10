package com.cactusli.springframework.tx.transaction.interceptor;

import com.cactusli.springframework.tx.transaction.support.DelegatingTransactionDefinition;

import java.io.Serializable;

/**
 * Created by cactusli on 2023/1/5 16:56
 */
public abstract class DelegatingTransactionAttribute extends DelegatingTransactionDefinition implements TransactionAttribute, Serializable {


    private final TransactionAttribute targetAttribute;


    public DelegatingTransactionAttribute(TransactionAttribute targetAttribute) {
        super(targetAttribute);
        this.targetAttribute = targetAttribute;
    }


    @Override
    public boolean rollbackOn(Throwable ex) {
        return this.targetAttribute.rollbackOn(ex);
    }

}

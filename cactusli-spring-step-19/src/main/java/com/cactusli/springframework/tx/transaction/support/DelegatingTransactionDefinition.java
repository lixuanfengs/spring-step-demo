package com.cactusli.springframework.tx.transaction.support;

import com.cactusli.springframework.tx.transaction.TransactionDefinition;

import java.io.Serializable;

/**
 * Created by cactusli on 2023/1/5 16:54
 */
public class DelegatingTransactionDefinition  implements TransactionDefinition, Serializable {

    private final TransactionDefinition targetDefinition;

    public DelegatingTransactionDefinition(TransactionDefinition targetDefinition) {
        this.targetDefinition = targetDefinition;
    }

    @Override
    public int getPropagationBehavior() {
        return this.targetDefinition.getPropagationBehavior();
    }

    @Override
    public int getIsolationLevel() {
        return this.targetDefinition.getIsolationLevel();
    }

    @Override
    public int getTimeout() {
        return this.targetDefinition.getTimeout();
    }

    @Override
    public boolean isReadOnly() {
        return this.targetDefinition.isReadOnly();
    }

    @Override
    public String getName() {
        return this.targetDefinition.getName();
    }


    @Override
    public boolean equals(Object other) {
        return this.targetDefinition.equals(other);
    }

    @Override
    public int hashCode() {
        return this.targetDefinition.hashCode();
    }

    @Override
    public String toString() {
        return this.targetDefinition.toString();
    }
}

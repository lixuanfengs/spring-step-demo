package com.cactusli.springframework.tx.transaction.interceptor;

import java.io.Serializable;

/**
 * Created by cactusli on 2023/1/5 15:07
 */
public class RollbackRuleAttribute implements Serializable {

    private final String exceptionName;

    public RollbackRuleAttribute(Class<?> clazz) {
        this.exceptionName = clazz.getName();
    }
}

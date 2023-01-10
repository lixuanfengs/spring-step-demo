package com.cactusli.springframework.tx.transaction.interceptor;

import com.cactusli.springframework.tx.transaction.TransactionDefinition;

/**
 * Created by cactusli on 2023/1/5 15:02
 */
public interface TransactionAttribute extends TransactionDefinition {

    boolean rollbackOn(Throwable ex);

}

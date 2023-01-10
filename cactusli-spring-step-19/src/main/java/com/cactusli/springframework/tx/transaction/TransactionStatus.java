package com.cactusli.springframework.tx.transaction;

import java.io.Flushable;
import java.io.IOException;

/**
 * Created by cactusli on 2023/1/5 16:14
 */
public interface TransactionStatus extends SavepointManager, Flushable {


    /**
     * 是否开启新的事务
     */
    boolean isNewTransaction();

    boolean hasSavepoint();

    void setRollbackOnly();

    boolean isRollbackOnly();

    @Override
    void flush() throws IOException;

    boolean isCompleted();

}

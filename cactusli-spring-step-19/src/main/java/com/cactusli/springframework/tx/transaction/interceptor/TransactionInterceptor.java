package com.cactusli.springframework.tx.transaction.interceptor;

import com.cactusli.springframework.tx.transaction.PlatformTransactionManager;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.io.Serializable;

/**
 * Created by cactusli on 2023/1/9 11:28
 */
public class TransactionInterceptor extends TransactionAspectSupport
        implements MethodInterceptor, Serializable {

    public TransactionInterceptor(PlatformTransactionManager ptm, TransactionAttributeSource transactionAttributeSource) {
        setTransactionManager(ptm);
        setTransactionAttributeSource(transactionAttributeSource);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return invokeWithinTransaction(invocation.getMethod(),
                invocation.getThis().getClass(), invocation::proceed);
    }
}

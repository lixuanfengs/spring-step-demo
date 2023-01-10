package com.cactusli.springframework.tx.transaction.interceptor;

import com.cactusli.springframework.aop.support.StaticMethodMatcherPointcut;
import com.cactusli.springframework.tx.transaction.PlatformTransactionManager;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by cactusli on 2023/1/9 15:07
 */
public abstract class TransactionAttributeSourcePointcut extends StaticMethodMatcherPointcut implements Serializable {

    @Override
    public boolean matches(Method method, Class<?> clazz) {
        if (PlatformTransactionManager.class.isAssignableFrom(clazz)) {
            return false;
        }

        TransactionAttributeSource tas = getTransactionAttributeSource();

        return null == tas || tas.getTransactionAttribute(method, clazz) != null;
    }


    //---------------------------------------------------------------------
    // Abstract methods to be implemented by subclasses start
    //---------------------------------------------------------------------

    protected abstract TransactionAttributeSource getTransactionAttributeSource();

    //---------------------------------------------------------------------
    // Abstract methods to be implemented by subclasses end
    //---------------------------------------------------------------------

}

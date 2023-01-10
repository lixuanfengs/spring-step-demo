package com.cactusli.springframework.tx.transaction.interceptor;

import java.lang.reflect.Method;

/**
 * Created by cactusli on 2023/1/5 15:22
 */
public interface TransactionAttributeSource {

    TransactionAttribute getTransactionAttribute(Method method, Class<?> targetClass);

}

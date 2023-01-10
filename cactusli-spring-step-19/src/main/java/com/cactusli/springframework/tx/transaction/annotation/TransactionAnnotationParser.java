package com.cactusli.springframework.tx.transaction.annotation;

import com.cactusli.springframework.tx.transaction.interceptor.TransactionAttribute;

import java.lang.reflect.AnnotatedElement;

/**
 * Created by cactusli on 2023/1/5 15:12
 */
public interface TransactionAnnotationParser {

    TransactionAttribute parseTransactionAnnotation(AnnotatedElement element);
}

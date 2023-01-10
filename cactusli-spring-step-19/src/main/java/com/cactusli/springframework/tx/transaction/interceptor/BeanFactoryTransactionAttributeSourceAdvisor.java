package com.cactusli.springframework.tx.transaction.interceptor;

import com.cactusli.springframework.aop.ClassFilter;
import com.cactusli.springframework.aop.Pointcut;
import com.cactusli.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * Created by cactusli on 2023/1/9 11:30
 */
public class BeanFactoryTransactionAttributeSourceAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private TransactionAttributeSource transactionAttributeSource;

    private final TransactionAttributeSourcePointcut pointcut=new TransactionAttributeSourcePointcut() {
        @Override
        protected TransactionAttributeSource getTransactionAttributeSource() {
            return transactionAttributeSource;
        }
    };

    public void setTransactionAttributeSource(TransactionAttributeSource transactionAttributeSource) {
        this.transactionAttributeSource = transactionAttributeSource;
    }

    public void setClassFilter(ClassFilter classFilter){
        this.pointcut.setClassFilter(classFilter);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

}

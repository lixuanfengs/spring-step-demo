package com.cactusli.springframework.aop.support;

import com.cactusli.springframework.aop.ClassFilter;
import com.cactusli.springframework.aop.MethodMatcher;
import com.cactusli.springframework.aop.Pointcut;

/**
 * Created by cactusli on 2023/1/9 15:07
 */
public abstract class StaticMethodMatcherPointcut extends StaticMethodMatcher implements Pointcut {

    private ClassFilter classFilter = ClassFilter.TRUE;

    public void setClassFilter(ClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    public ClassFilter getClassFilter() {
        return classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}

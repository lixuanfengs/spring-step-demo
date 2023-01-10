package com.cactusli.springframework.aop.support;

import com.cactusli.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 * Created by cactusli on 2023/1/9 15:08
 */
public abstract class StaticMethodMatcher implements MethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> clazz) {
        throw new UnsupportedOperationException("Illegal MethodMatcher usage");
    }

}

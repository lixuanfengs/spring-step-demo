package com.cactusli.springframework.aop;

import java.lang.reflect.Method;

/**
 * Created by cactusli on 2022/12/21 10:36
 */
/**
 * Part of a {@link Pointcut}: Checks whether the target method is eligible for advice.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}

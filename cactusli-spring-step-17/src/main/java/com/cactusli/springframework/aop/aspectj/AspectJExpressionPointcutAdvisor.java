package com.cactusli.springframework.aop.aspectj;

import com.cactusli.springframework.aop.Pointcut;
import com.cactusli.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * Created by cactusli on 2022/12/22 10:27
 */
/**
 * Spring AOP Advisor that can be used for any AspectJ pointcut expression.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}

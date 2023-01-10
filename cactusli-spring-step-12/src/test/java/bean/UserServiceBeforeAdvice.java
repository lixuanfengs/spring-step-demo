package bean;

import com.cactusli.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by cactusli on 2022/12/22 15:26
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}

package com.cactusli.springframework.beans.factory;

/**
 * Created by cactusli on 2022/12/9 10:13
 */
/**
 * Interface to be implemented by beans that want to release resources
 * on destruction. A BeanFactory is supposed to invoke the destroy
 * method if it disposes a cached singleton. An application context
 * is supposed to dispose all of its singletons on close.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface DisposableBean {

    void destroy() throws Exception;
}

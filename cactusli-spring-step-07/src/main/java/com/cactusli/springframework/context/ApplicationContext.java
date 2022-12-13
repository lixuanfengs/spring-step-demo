package com.cactusli.springframework.context;

import com.cactusli.springframework.beans.factory.ListableBeanFactory;

/**
 * Created by cactusli on 2022/12/6 11:51
 */
/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 *
 * 应用上下文
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ApplicationContext extends ListableBeanFactory {

}

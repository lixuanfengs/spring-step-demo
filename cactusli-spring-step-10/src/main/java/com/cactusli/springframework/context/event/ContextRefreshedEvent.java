package com.cactusli.springframework.context.event;

/**
 * Created by cactusli on 2022/12/19 16:34
 */
/**
 * Event raised when an <code>ApplicationContext</code> gets initialized or refreshed.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}

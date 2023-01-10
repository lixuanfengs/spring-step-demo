package com.cactusli.springframework.context.event;

import com.cactusli.springframework.context.ApplicationContext;
import com.cactusli.springframework.context.ApplicationEvent;

/**
 * Created by cactusli on 2022/12/19 15:58
 */
/**
 * Base class for events raised for an <code>ApplicationContext</code>.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}

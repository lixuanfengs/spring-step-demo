package com.cactusli.springframework.beans;

/**
 * Created by cactusli on 2022/11/30 10:23
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

package com.cactusli.springframework.core.annotation;

/**
 * Created by cactusli on 2023/1/10 10:10
 */
public class AnnotationConfigurationException extends RuntimeException {
    public AnnotationConfigurationException(String message) {
        super(message);
    }

    public AnnotationConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}

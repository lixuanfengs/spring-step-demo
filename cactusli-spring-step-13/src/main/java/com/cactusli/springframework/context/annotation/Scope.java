package com.cactusli.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * Created by cactusli on 2022/12/22 16:59
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}

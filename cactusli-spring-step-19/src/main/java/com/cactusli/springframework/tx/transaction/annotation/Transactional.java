package com.cactusli.springframework.tx.transaction.annotation;

import java.lang.annotation.*;

/**
 * Created by cactusli on 2023/1/5 15:11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Transactional {

    Class<? extends Throwable>[] rollbackFor() default {};
}

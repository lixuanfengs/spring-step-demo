package com.cactusli.springframework.stereotype;

import java.lang.annotation.*;

/**
 * Created by cactusli on 2022/12/22 17:01
 */
/**
 * Indicates that an annotated class is a "component".
 * Such classes are considered as candidates for auto-detection
 * when using annotation-based configuration and classpath scanning.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}

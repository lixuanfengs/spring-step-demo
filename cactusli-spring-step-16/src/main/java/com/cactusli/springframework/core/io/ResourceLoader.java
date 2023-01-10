package com.cactusli.springframework.core.io;

/**
 * Created by cactusli on 2022/12/2 9:43
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}

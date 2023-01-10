package com.cactusli.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cactusli on 2022/12/2 9:22
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}

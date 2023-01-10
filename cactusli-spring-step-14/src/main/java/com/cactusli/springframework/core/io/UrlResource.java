package com.cactusli.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cactusli on 2022/12/2 9:38
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try{
            return connection.getInputStream();
        } catch (IOException e) {
            if (connection instanceof HttpURLConnection){
                ((HttpURLConnection) connection).disconnect();
            }
            throw  e;
        }
    }
}

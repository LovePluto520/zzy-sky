package com.sky.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

//@SpringBootTest
public class HttpClientTest {
    /**
     *
     * 发送get方式请求
     */
    @Test
    public  void  testGET() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务端返回的状态码为："+statusCode);

        HttpEntity entity = response.getEntity();

        String body = EntryUtils.toString(entity);
        System.out.println("服务端返回的数据为："+body);


        response.close();
        httpClient.close();


    }
}

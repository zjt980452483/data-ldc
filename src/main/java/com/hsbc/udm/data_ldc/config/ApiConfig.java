package com.hsbc.udm.data_ldc.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class ApiConfig {
    
//    private UserInfo userinfo;
//
//    @Data
//    public static class UserInfo {
//        private String url;
//    }

    @Bean
    public RestTemplate restTemplate() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(20)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(5));  // 设置连接超时
        factory.setReadTimeout((int) TimeUnit.SECONDS.toMillis(5));     // 设置读取超时

        return new RestTemplate(factory);
    }
} 
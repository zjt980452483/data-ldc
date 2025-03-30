package com.hsbc.udm.data_ldc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hsbc.udm.data_ldc.config.ApiConfig;
import com.hsbc.udm.data_ldc.service.UserInfoService;

/**
 * 用户信息服务实现类
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final String USER_INFO_URL = "http://127.0.0.1:9090/api/userInfo";

    private final RestTemplate restTemplate;
    
    @Autowired
    public UserInfoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    public Object getUserInfo() {
        logger.info("Fetching user information from external API");
        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(USER_INFO_URL, Object.class);
            logger.info("Successfully fetched user information");
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error fetching user information", e);
            throw new RuntimeException("Failed to fetch user information", e);
        }
    }

} 
package com.hsbc.udm.data_ldc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.hsbc.udm.data_ldc.service.UserInfoService;
import com.hsbc.udm.data_ldc.exception.ExternalApiException;

/**
 * 用户信息服务实现类
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Value("${api.user-info-url}")
    private String userInfoUrl;

    private final RestTemplate restTemplate;
    
    @Autowired
    public UserInfoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    public Object getUserInfo() {
        logger.info("Fetching user information from external API: {}", userInfoUrl);
        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(userInfoUrl, Object.class);
            logger.info("Successfully fetched user information");
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            logger.error("Client error when calling external API: {}", ex.getMessage(), ex);
            throw ex; // 直接抛出，让全局异常处理器处理
        } catch (HttpServerErrorException ex) {
            logger.error("Server error when calling external API: {}", ex.getMessage(), ex);
            throw ex; // 直接抛出，让全局异常处理器处理
        } catch (ResourceAccessException ex) {
            logger.error("Connection error when calling external API: {}", ex.getMessage(), ex);
            throw ex; // 直接抛出，让全局异常处理器处理
        } catch (Exception e) {
            logger.error("Unexpected error fetching user information: {}", e.getMessage(), e);
            throw new ExternalApiException("Failed to fetch user information: " + e.getMessage(), e);
        }
    }

} 
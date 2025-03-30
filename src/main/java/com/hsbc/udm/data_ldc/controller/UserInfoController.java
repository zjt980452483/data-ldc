package com.hsbc.udm.data_ldc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.udm.data_ldc.service.UserInfoService;

/**
 * 用户信息控制器
 */
@RestController
@RequestMapping("/api")
public class UserInfoController {
    
    private final UserInfoService userInfoService;
    
    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
    
    /**
     * 获取所有用户信息
     * @return 用户信息
     */
    @GetMapping("/userinfo")
    public ResponseEntity<Object> getUserInfo() {
        Object userInfo = userInfoService.getUserInfo();
        return ResponseEntity.ok(userInfo);
    }
} 
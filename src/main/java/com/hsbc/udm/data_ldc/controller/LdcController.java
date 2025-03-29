package com.hsbc.udm.data_ldc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @version 1.0
 */
@RestController
@RequestMapping("/api/ldc")
public class LdcController {
    
    /**
     * 简单的Hello World测试方法
     * @return 问候消息
     */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World from LDC Controller!";
    }
}

package com.hsbc.udm.data_ldc.service;

import com.hsbc.udm.data_ldc.entity.UserInfoEntity;

/**
 * 用户信息服务接口
 */
public interface UserInfoService {
    
    /**
     * 获取用户信息
     * @return 用户信息
     */
    UserInfoEntity getUserInfo();

} 
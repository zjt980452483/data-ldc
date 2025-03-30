package com.hsbc.udm.data_ldc.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsbc.udm.data_ldc.entity.UserInfoEntity;

/**
 * @author  zjt
 * @version 1.0
 */

public class ApiResponse {

    private int code;
    private String message;

    @JsonProperty("data")
    private UserInfoEntity userInfo;

    // Getters 和 Setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }
}
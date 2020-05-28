package com.loven.myshop.plus.business.oauth2.dto;

import lombok.Data;

/**
 * 登录参数实体
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/22.
 */
@Data
public class LoginParam {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

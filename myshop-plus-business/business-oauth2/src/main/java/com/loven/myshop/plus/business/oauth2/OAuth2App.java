package com.loven.myshop.plus.business.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证服务器
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
@SpringBootApplication(scanBasePackages = "com.loven")
@EnableDiscoveryClient
public class OAuth2App {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2App.class, args);
    }
}

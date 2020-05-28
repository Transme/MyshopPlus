package com.loven.myshop.plus.business.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
@SpringBootApplication(scanBasePackages = {"com.loven"})
@EnableDiscoveryClient
public class UserServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class, args);
    }
}

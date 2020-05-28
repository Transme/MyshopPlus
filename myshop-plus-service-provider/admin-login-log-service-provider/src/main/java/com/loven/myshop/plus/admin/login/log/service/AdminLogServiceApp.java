package com.loven.myshop.plus.admin.login.log.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.loven.myshop.plus.admin.login.log.service.mapper"})
public class AdminLogServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminLogServiceApp.class, args);
    }
}

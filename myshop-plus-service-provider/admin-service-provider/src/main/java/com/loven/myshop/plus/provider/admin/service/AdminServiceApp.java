package com.loven.myshop.plus.provider.admin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description 启动类
 *
 * @author loven.
 * @date 2020/5/20.
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.loven.myshop.plus.provider.admin.service.mapper"})
public class AdminServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApp.class, args);
    }
}

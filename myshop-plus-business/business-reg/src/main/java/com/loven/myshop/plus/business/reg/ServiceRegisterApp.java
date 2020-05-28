package com.loven.myshop.plus.business.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/20.
 */
@SpringBootApplication(scanBasePackages = "com.loven")
@EnableDiscoveryClient
public class ServiceRegisterApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegisterApp.class, args);
    }
}

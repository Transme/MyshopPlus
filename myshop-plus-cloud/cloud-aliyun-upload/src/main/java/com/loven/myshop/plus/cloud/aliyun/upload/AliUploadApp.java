package com.loven.myshop.plus.cloud.aliyun.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/25.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliUploadApp {
    public static void main(String[] args) {
        SpringApplication.run(AliUploadApp.class, args);
    }
}

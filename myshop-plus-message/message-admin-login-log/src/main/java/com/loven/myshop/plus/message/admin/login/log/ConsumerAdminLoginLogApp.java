package com.loven.myshop.plus.message.admin.login.log;

import com.loven.myshop.plus.message.admin.login.log.sink.AdminLoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(AdminLoginLogSink.class)
public class ConsumerAdminLoginLogApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerAdminLoginLogApp.class, args);
    }
}

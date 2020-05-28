package com.loven.myshop.plus.cloud.message;

import com.loven.myshop.plus.cloud.message.configure.MessageSource;
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
@EnableBinding(value = MessageSource.class)
public class MessageProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(MessageProviderApp.class, args);
    }
}

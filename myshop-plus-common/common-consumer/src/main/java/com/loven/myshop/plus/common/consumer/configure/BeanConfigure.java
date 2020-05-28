package com.loven.myshop.plus.common.consumer.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * dubbo 服务消费者通用 bean 配置类
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
@Configuration
public class BeanConfigure {
    @Bean
    public BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
}

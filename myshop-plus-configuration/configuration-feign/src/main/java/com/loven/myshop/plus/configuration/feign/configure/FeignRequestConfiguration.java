package com.loven.myshop.plus.configuration.feign.configure;

import com.loven.myshop.plus.configuration.feign.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/24.
 */
@Configuration
public class FeignRequestConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }

}
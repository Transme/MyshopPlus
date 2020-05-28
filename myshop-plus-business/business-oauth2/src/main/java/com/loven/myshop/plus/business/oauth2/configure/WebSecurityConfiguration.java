package com.loven.myshop.plus.business.oauth2.configure;

import com.loven.myshop.plus.business.oauth2.controller.LoginController;
import com.loven.myshop.plus.business.oauth2.service.UserDetailsServiceImpl;
import com.loven.myshop.plus.common.constant.AuthorityName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean("userDetailsServiceBean")
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义认证与授权
        try {
            auth.userDetailsService(userDetailsService());
        } finally {
            LoginController.threadLocal.remove();
        }
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web
                .ignoring()
                .antMatchers("/oauth/check_token")
                .antMatchers("/user/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 将授权访问配置改为注解方式
         * @see LoginController#info()
         */
        http.exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/info").hasAuthority(AuthorityName.BASE_AUTHORITY)
//                .antMatchers("/user/logout").hasAuthority(AuthorityName.BASE_AUTHORITY);
//        http.exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                // 授权访问
//                .antMatchers("/user/info").hasAuthority("USER")
//                .antMatchers("/user/logout").hasAuthority("USER");
    }
}

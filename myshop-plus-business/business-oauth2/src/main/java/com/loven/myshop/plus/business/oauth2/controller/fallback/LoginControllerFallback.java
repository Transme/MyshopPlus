package com.loven.myshop.plus.business.oauth2.controller.fallback;

import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.common.dto.ResponseResult;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录服务熔断类
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/26.
 */
public class LoginControllerFallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerFallback.class);
    private static final String MESSAGE = "网络异常，请检查您的网络";

    public static ResponseResult<UmsAdmin> loginFallback(String username, Throwable ex){
        LOGGER.warn("invoke loginFallback: " + ex.getClass().getTypeName());
        return ResponseResult.fail(CodeStatus.BREAKING, MESSAGE);
    }
}

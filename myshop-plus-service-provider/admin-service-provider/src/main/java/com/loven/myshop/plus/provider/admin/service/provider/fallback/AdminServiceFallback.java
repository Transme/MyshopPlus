package com.loven.myshop.plus.provider.admin.service.provider.fallback;

import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/26.
 */
public class AdminServiceFallback {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceFallback.class);

    public static UmsAdmin selectOneFallback(String username, Throwable ex){
        logger.warn("invoke selectOneFallback: " + ex.getClass().getTypeName());
        return null;
    }
}
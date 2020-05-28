package com.loven.myshop.plus.message.admin.login.log.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
public interface AdminLoginLogSink {
    /**
     * description
     *
     * @author loven
     * @date  18:33:45
     * @param
     * @return org.springframework.messaging.SubscribableChannel {@link SubscribableChannel}
     * @throws
     */
    @Input("admin-login-log-topic")
    SubscribableChannel adminLoginLog();
}

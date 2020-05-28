package com.loven.myshop.plus.cloud.message.configure;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
public interface MessageSource {
    /**
     * description
     *
     * @author loven
     * @date  12:53:20
     * @param
     * @return org.springframework.messaging.MessageChannel {@link MessageChannel}
     * @throws
     */
    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();
}

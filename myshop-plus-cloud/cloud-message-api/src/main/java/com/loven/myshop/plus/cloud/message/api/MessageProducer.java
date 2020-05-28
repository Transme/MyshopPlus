package com.loven.myshop.plus.cloud.message.api;

import com.loven.myshop.plus.cloud.message.dto.AdminLoginLog;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
public interface MessageProducer {
    /**
     * description
     *
     * @author loven
     * @date  15:57:18
     * @param log {@link String}
     * @throws
     */
    void sendAdminLoginLog(AdminLoginLog log);
}

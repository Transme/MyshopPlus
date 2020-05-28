package com.loven.myshop.plus.message.admin.login.log.consumer;

import com.loven.myshop.plus.admin.login.log.service.api.AdminLogService;
import com.loven.myshop.plus.admin.login.log.service.domain.UmsAdminLoginLog;
import com.loven.myshop.plus.common.utils.MapperUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
@Service
public class AdminLoginLogConsumer {

    @Reference(version = "1.0.0")
    private AdminLogService adminLogService;

    @StreamListener("admin-login-log-topic")
    public void receiveAdminLoginLog(String adminLoginLogJson){
        try {
            UmsAdminLoginLog log = MapperUtils.json2pojo(adminLoginLogJson, UmsAdminLoginLog.class);
            adminLogService.insert(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

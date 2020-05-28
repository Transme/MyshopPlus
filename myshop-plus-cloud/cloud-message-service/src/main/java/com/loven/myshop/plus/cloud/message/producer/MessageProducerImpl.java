package com.loven.myshop.plus.cloud.message.producer;

import com.loven.myshop.plus.cloud.message.api.MessageProducer;
import com.loven.myshop.plus.cloud.message.configure.MessageSource;
import com.loven.myshop.plus.cloud.message.dto.AdminLoginLog;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
@Service(version = "1.0.0")
public class MessageProducerImpl implements MessageProducer {
    @Resource
    private MessageSource source;

    @Override
    public void sendAdminLoginLog(AdminLoginLog log){
        source.adminLoginLog().send(MessageBuilder.withPayload(log).build());
    }
}

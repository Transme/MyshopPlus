package com.loven.myshop.plus.business.reg.service;

import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import com.loven.myshop.plus.common.dto.ResponseResult;

/**
 * @description 用户注册服务消费端接口
 *
 * @author loven.
 * @date 2020/5/20.
 */
public interface RegisterService {
    /**
     * 用户注册服务消费者
     *
     * @author loven
     * @date  16:12:42
     * @param umsAdmin {@link String}
     * @return common.dto.ResponseResult<Object> {@link ResponseResult<Object>}
     * @throws
     */
    ResponseResult<Object> register(UmsAdmin umsAdmin);
}

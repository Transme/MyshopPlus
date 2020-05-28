package com.loven.myshop.plus.business.reg.service.impl;

import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.provider.admin.service.api.AdminService;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import com.loven.myshop.plus.business.reg.service.RegisterService;
import com.loven.myshop.plus.common.dto.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description 用户注册类.
 * @author loven.
 * @date 2020/5/20.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Reference(version = "1.0.0")
    private AdminService service;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public ResponseResult<Object> register(UmsAdmin umsAdmin) {
        umsAdmin.setPassword(encoder.encode(umsAdmin.getPassword()));
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        int status = service.register(umsAdmin);
        if(status >= 1){
            return ResponseResult.success("注册成功");
        }
        else{
            return ResponseResult.fail(CodeStatus.FAIL, "网络异常，请稍后再试试！");
        }
    }
}

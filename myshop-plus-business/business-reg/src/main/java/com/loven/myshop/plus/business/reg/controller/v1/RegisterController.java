package com.loven.myshop.plus.business.reg.controller.v1;

import com.loven.myshop.plus.business.reg.dto.RegisterInfo;
import com.loven.myshop.plus.common.constant.CodeStatus;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import com.loven.myshop.plus.business.reg.service.RegisterService;
import com.loven.myshop.plus.common.consumer.utils.ValidateUtils;
import com.loven.myshop.plus.common.dto.ResponseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接收、处理注册请求
 *
 * @author loven.
 * @date 2020/5/20.
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("register")
    public ResponseResult<Object> register(@Valid @RequestBody RegisterInfo info, Errors errors){
        String errorString = ValidateUtils.getErrors(errors);
        if(StringUtils.isNotBlank(errorString)){
            return ResponseResult.fail(CodeStatus.ILLEGAL_PARAMS, errorString);
        }
        else{
            UmsAdmin admin = new UmsAdmin();
            admin.setUsername(info.getUsername());
            admin.setPassword(info.getPassword());
            return registerService.register(admin);
        }
    }
}

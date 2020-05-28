package com.loven.myshop.plus.business.reg.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/24.
 */
@Data
public class RegisterInfo {
    @NotNull(message = "用户名不能为空！")
    @Length(min = 6, max = 12, message = "用户名长度必须介于 6 和 12 之间")
    private String username;
    @NotNull(message = "密码不能为空！")
    @Length(min = 6, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    private String password;
}

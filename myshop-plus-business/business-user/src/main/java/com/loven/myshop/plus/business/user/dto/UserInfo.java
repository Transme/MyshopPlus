package com.loven.myshop.plus.business.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/22.
 */
@Data
public class UserInfo implements Serializable {
    private String name;
    private String avatar;
    private String nickName;
}

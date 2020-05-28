package com.loven.myshop.plus.business.user.dto;

import lombok.Data;

/**
 * 接收基本更新信息
 *
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/25.
 */
@Data
public class ModifieInfo {
    private long id;
    private String username;
    private String password;
    private String note;
    private String avatar;
    private String nickName;
    private String email;
    private int status;
}

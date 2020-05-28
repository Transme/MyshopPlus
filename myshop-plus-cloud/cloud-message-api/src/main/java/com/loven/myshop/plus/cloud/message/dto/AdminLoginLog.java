package com.loven.myshop.plus.cloud.message.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
@Data
public class AdminLoginLog implements Serializable {
    private Long id;
    private Long adminId;
    private Date createTime;

    /**
     * 登录的机器ip
     */
    private String ip;

    /**
     * 登录的地理位置
     */
    private String address;

    /**
     * 浏览器登录类型
     */
    private String userAgent;

    private static final long serialVersionUID = 1L;
}

package com.loven.myshop.plus.provider.admin.service.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loven.myshop.plus.common.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 后台用户表
 *
 * @author loven.
 * @date 2020/5/20.
 * @version 1.0.0
 */
@Data
@Table(name = "ums_admin")
public class UmsAdmin implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @NotNull(message = "用户名不能为空！")
    @Length(min = 6, max = 12, message = "用户名长度必须介于 6 和 12 之间")
    @Column(name = "username")
    private String username;

    @NotNull(message = "密码不能为空！")
    @Length(min = 6, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    @Column(name = "`password`")
    @JsonIgnore
    private String password;

    /**
     * 头像
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 邮箱
     */
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    @Column(name = "email")
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    @Column(name = "note")
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @Column(name = "`status`")
    private Integer status;

    private static final long serialVersionUID = 1L;
}
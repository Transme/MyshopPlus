package com.loven.myshop.plus.provider.admin.service.api;

import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;

import java.util.List;

/**
 * 管理员服务接口
 *
 * @author loven.
 * @date 2020/5/20.
 */
public interface AdminService {
    /**
     * 用户注册服务提供端
     *
     * @author loven
     * @date  15:55:23
     * @param user {@link Integer}
     * @return Integer
     * @throws 
     */
    int register(UmsAdmin user);

    /**
     * description
     *
     * @author loven
     * @date  17:36:17
     * @param username {@link String}
     * @return com.loven.admin.service.domain.UmsAdmin {@link UmsAdmin}
     * @throws
     */
    UmsAdmin selectOne(String username);

    /**
     * 按用户所有信息查询
     *
     * @author loven
     * @date  18:47:21
     * @param umsAdmin {@link UmsAdmin}
     * @return com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin {@link UmsAdmin}
     * @throws
     */
    UmsAdmin selectOneByEntity(UmsAdmin umsAdmin);

    /**
     * 查询全部用户
     *
     * @author loven
     * @date  18:48:16
     * @param
     * @return java.util.List<com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin> {@link List < UmsAdmin>}
     * @throws
     */
    List<UmsAdmin> selectAll();

    /**
     * 更新登录时间
     *
     * @author loven
     * @date  13:35:25
     * @param
     * @return int {@link int}
     * @throws
     */
    int updateLoginTime(UmsAdmin umsAdmin);

    /**
     * 更新一般信息
     *
     * @author loven
     * @date  13:19:40
     * @param umsAdmin {@link UmsAdmin}
     * @return int {@link int}
     * @throws
     */
    int updateInfo(UmsAdmin umsAdmin);

    /**
     * 更新头像
     *
     * @author loven
     * @date  13:20:00
     * @param umsAdmin {@link UmsAdmin}
     * @return int {@link int}
     * @throws
     */
    int updateIcon(UmsAdmin umsAdmin);

    /**
     * 更新密码
     *
     * @author loven
     * @date  13:20:22
     * @param umsAdmin {@link UmsAdmin}
     * @return int {@link int}
     * @throws
     */
    int updatePassword(UmsAdmin umsAdmin);
}

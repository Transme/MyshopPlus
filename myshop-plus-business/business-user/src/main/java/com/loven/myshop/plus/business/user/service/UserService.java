package com.loven.myshop.plus.business.user.service;

import com.loven.myshop.plus.business.user.dto.ModifieInfo;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;

import java.util.List;

/**
 * dubbo 消费端登录服务接口
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
public interface UserService {
    /**
     * 按用户名查询
     *
     * @author loven
     * @date  18:45:12
     * @param username {@link String}
     * @return com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin {@link UmsAdmin}
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
     * @return java.util.List<com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin> {@link List< UmsAdmin>}
     * @throws
     */
    List<UmsAdmin> selectAll();

    /**
     * 更新基本信息
     *
     * @author loven
     * @date  13:58:02
     * @param modifieInfo {@link ModifieInfo}
     * @return int {@link int}
     * @throws
     */
    int modifiedInfo(ModifieInfo modifieInfo);

    /**
     * 更新头像
     *
     * @author loven
     * @date  14:16:49
     * @param modifieInfo {@link ModifieInfo}
     * @return int {@link int}
     * @throws
     */
    int modifiedIcon(ModifieInfo modifieInfo);

    /**
     * 更新密码
     *
     * @author loven
     * @date  14:17:24
     * @param modifieInfo {@link ModifieInfo}
     * @return int {@link int}
     * @throws
     */
    int modifiedPassword(ModifieInfo modifieInfo);
}

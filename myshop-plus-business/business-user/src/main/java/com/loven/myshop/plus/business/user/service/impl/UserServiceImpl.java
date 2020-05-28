package com.loven.myshop.plus.business.user.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.loven.myshop.plus.business.user.dto.ModifieInfo;
import com.loven.myshop.plus.business.user.service.UserService;
import com.loven.myshop.plus.provider.admin.service.api.AdminService;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录服务接口实现类
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Reference(version = "1.0.0", protocol = "dubbo")
    private AdminService adminService;

    @Override
    public UmsAdmin selectOne(String username) {
        return adminService.selectOne(username);
    }

    @Override
    public UmsAdmin selectOneByEntity(UmsAdmin umsAdmin) {
        return adminService.selectOneByEntity(umsAdmin);
    }

    @Override
    public List<UmsAdmin> selectAll() {
        return adminService.selectAll();
    }

    @Override
    public int modifiedInfo(ModifieInfo modifieInfo) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(modifieInfo, umsAdmin);
        return adminService.updateInfo(umsAdmin);
    }

    @Override
    public int modifiedIcon(ModifieInfo modifieInfo) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(modifieInfo, umsAdmin);
        umsAdmin.setIcon(modifieInfo.getAvatar());
        return adminService.updateIcon(umsAdmin);
    }

    @Override
    public int modifiedPassword(ModifieInfo modifieInfo) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(modifieInfo, umsAdmin);
        return adminService.updatePassword(umsAdmin);
    }
}

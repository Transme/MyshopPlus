package com.loven.myshop.plus.business.oauth2.service;

import com.loven.myshop.plus.business.oauth2.controller.LoginController;
import com.loven.myshop.plus.provider.admin.service.api.AdminService;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/27.
 */
@Service
public class UserService {
    @Reference(version = "1.0.0", protocol = "dubbo")
    private AdminService adminService;

    UmsAdmin getAdminByName(String name){
        UmsAdmin umsAdmin = adminService.selectOne(name);
        LoginController.threadLocal.set(umsAdmin);
        return umsAdmin;
    }

    void updateLoginTime(UmsAdmin umsAdmin){
        adminService.updateLoginTime(umsAdmin);
    }
}

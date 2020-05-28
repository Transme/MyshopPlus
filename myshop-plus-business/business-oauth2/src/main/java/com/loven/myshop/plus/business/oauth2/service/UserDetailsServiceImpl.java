package com.loven.myshop.plus.business.oauth2.service;

import com.google.common.collect.Lists;
import com.loven.myshop.plus.common.constant.AuthorityName;
import com.loven.myshop.plus.provider.admin.service.api.AdminService;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/21.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Resource
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UmsAdmin umsAdmin = service.getAdminByName(s);
        if(umsAdmin != null){
            //更新登录时间
            umsAdmin.setLoginTime(new Date());
            service.updateLoginTime(umsAdmin);
            //授权
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            grantedAuthorities.add(new SimpleGrantedAuthority(AuthorityName.BASE_AUTHORITY));
            return new User(umsAdmin.getUsername(), umsAdmin.getPassword(), grantedAuthorities);
        }
        return null;
    }
}

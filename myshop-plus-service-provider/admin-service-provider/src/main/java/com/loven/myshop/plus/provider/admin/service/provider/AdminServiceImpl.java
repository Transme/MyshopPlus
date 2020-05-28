package com.loven.myshop.plus.provider.admin.service.provider;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.loven.myshop.plus.provider.admin.service.api.AdminService;
import com.loven.myshop.plus.provider.admin.service.domain.UmsAdmin;
import com.loven.myshop.plus.provider.admin.service.mapper.UmsAdminMapper;
import com.loven.myshop.plus.provider.admin.service.provider.fallback.AdminServiceFallback;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员服务接口实现类，dubbo 服务提供者
 *
 * @author loven.
 * @date 2020/5/20.
 */
@Service(version = "1.0.0")
public class AdminServiceImpl implements AdminService {
    @Resource
    private UmsAdminMapper mapper;

    /**
     * 注册服务提供端
     *
     * @author loven
     * @date  16:02:55
     * @param user {@link Integer}
     * @return com.loven.admin.service.domain.UmsAdmin {@link UmsAdmin}
     * @throws
     */
    @Override
    public int register(UmsAdmin user) {
        return mapper.insert(user);
    }

    @Override
    @SentinelResource(value = "selectOneByName", fallback = "selectOneFallback", fallbackClass = AdminServiceFallback.class)
    public UmsAdmin selectOne(String username) {
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username", username);
        return mapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin selectOneByEntity(UmsAdmin umsAdmin) {
        return mapper.selectOne(umsAdmin);
    }

    @Override
    public List<UmsAdmin> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateLoginTime(UmsAdmin umsAdmin) {
        return mapper.updateByPrimaryKey(umsAdmin);
    }

    @Override
    public int updateInfo(UmsAdmin umsAdmin) {
        UmsAdmin admin = selectOne(umsAdmin.getUsername());
        admin.setNickName(umsAdmin.getNickName());
        admin.setEmail(umsAdmin.getEmail());
        admin.setNote(umsAdmin.getNote());
        admin.setStatus(umsAdmin.getStatus());
        return mapper.updateByPrimaryKey(admin);
    }

    @Override
    public int updateIcon(UmsAdmin umsAdmin) {
        UmsAdmin admin = selectOne(umsAdmin.getUsername());
        admin.setIcon(umsAdmin.getIcon());
        return mapper.updateByPrimaryKey(admin);
    }

    @Override
    public int updatePassword(UmsAdmin umsAdmin) {
        UmsAdmin admin = selectOne(umsAdmin.getUsername());
        admin.setPassword(umsAdmin.getPassword());
        return mapper.updateByPrimaryKey(admin);
    }

}

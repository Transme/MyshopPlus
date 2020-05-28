package com.loven.myshop.plus.admin.login.log.service.provider;

import com.loven.myshop.plus.admin.login.log.service.api.AdminLogService;
import com.loven.myshop.plus.admin.login.log.service.domain.UmsAdminLoginLog;
import com.loven.myshop.plus.admin.login.log.service.mapper.UmsAdminLoginLogMapper;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/26.
 */
@Service(version = "1.0.0")
public class AdminLogServiceImpl implements AdminLogService {

    @Resource
    UmsAdminLoginLogMapper mapper;

    @Override
    public int insert(UmsAdminLoginLog log) {
        return mapper.insert(log);
    }

    @Override
    public UmsAdminLoginLog selectOne(Long logId) {
        Example example = new Example(UmsAdminLoginLog.class);
        example.createCriteria().andEqualTo("id", logId);
        return mapper.selectOneByExample(example);
    }

    @Override
    public List<UmsAdminLoginLog> selectByAdminId(Long adminId) {
        Example example = new Example(UmsAdminLoginLog.class);
        example.createCriteria().andEqualTo("adminId", adminId);
        return mapper.selectByExample(example);
    }
}

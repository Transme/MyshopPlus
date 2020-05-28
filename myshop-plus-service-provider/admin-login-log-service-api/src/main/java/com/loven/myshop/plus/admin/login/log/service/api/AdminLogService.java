package com.loven.myshop.plus.admin.login.log.service.api;

import com.loven.myshop.plus.admin.login.log.service.domain.UmsAdminLoginLog;

import java.util.List;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/26.
 */
public interface AdminLogService {
    /**
     * description
     *
     * @author loven
     * @date  22:08:53
     * @param log {@link UmsAdminLoginLog}
     * @return int {@link int}
     * @throws
     */
    int insert(UmsAdminLoginLog log);

    /**
     * description
     *
     * @author loven
     * @date  22:08:58
     * @param logId {@link Long}
     * @return com.loven.myshop.plus.admin.login.log.service.domain.UmsAdminLoginLog {@link UmsAdminLoginLog}
     * @throws
     */
    UmsAdminLoginLog selectOne(Long logId);

    /**
     * description
     *
     * @author loven
     * @date  22:09:05
     * @param id {@link Long}
     * @return java.util.List<com.loven.myshop.plus.admin.login.log.service.domain.UmsAdminLoginLog> {@link List< UmsAdminLoginLog>}
     * @throws
     */
    List<UmsAdminLoginLog> selectByAdminId(Long adminId);
}

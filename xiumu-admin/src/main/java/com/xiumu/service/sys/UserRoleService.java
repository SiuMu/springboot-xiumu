package com.xiumu.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.pojo.sys.entity.UserRole;

/**
 * 用户角色关联 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 删除 用户角色关联
     *
     * @param userId 用户 ID
     * @return
     */
    boolean deleteByUserId(Long userId);
}

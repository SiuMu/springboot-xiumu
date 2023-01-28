package com.xiumu.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.pojo.sys.dto.UserRoleDTO;
import com.xiumu.pojo.sys.entity.UserRole;

/**
 * 用户角色关联 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 创建 用户角色关联
     *
     * @param userRoleDTO userRole 信息
     * @return
     */
    boolean create(UserRoleDTO userRoleDTO);

    /**
     * 更新 用户角色关联
     *
     * @param userRoleDTO 更新内容
     * @param id 主键 ID
     * @return
     */
    boolean updateById(UserRoleDTO userRoleDTO, String id);

    /**
     * 删除 用户角色关联
     *
     * @param userId 用户 ID
     * @return
     */
    boolean deleteByUserId(String userId);
}

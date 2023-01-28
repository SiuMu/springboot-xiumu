package com.xiumu.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.pojo.sys.dto.RoleAuthDTO;
import com.xiumu.pojo.sys.entity.RoleAuth;

import java.util.List;

/**
 * 角色权限关联 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
public interface RoleAuthService extends IService<RoleAuth> {

    /**
     * 创建 角色权限关联
     *
     * @param roleAuthDTO roleAuth 信息
     * @return
     */
    boolean create(RoleAuthDTO roleAuthDTO);

    /**
     * 根据角色 ID 查询
     * @param roleId 角色 ID
     * @return
     */
    List<RoleAuth> listByRoleId(String roleId);
}

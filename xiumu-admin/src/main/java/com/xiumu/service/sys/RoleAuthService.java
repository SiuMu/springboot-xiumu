package com.xiumu.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.dto.RoleAuthDTO;
import com.xiumu.pojo.sys.entity.RoleAuth;
import com.xiumu.pojo.sys.query.RoleAuthQuery;

import java.util.List;

/**
 * 角色权限关联 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
public interface RoleAuthService extends IService<RoleAuth> {

    /**
     * 分页查询
     *
     * @param pageQuery 分页条件
     * @return
     */
    IPage<RoleAuth> listPage(PageQuery<RoleAuthQuery, RoleAuth> pageQuery);

    /**
     * 根据条件查询 角色权限关联
     *
     * @param roleAuth 查询条件
     * @return
     */
    List<RoleAuth> listByRoleAuth(RoleAuthQuery roleAuth);

    /**
     * 创建 角色权限关联
     *
     * @param roleAuthDTO roleAuth 信息
     * @return
     */
    boolean create(RoleAuthDTO roleAuthDTO);


    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(Long id);
}

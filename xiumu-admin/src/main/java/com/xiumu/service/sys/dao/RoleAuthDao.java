package com.xiumu.service.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.pojo.sys.entity.RoleAuth;
import com.xiumu.pojo.sys.model.dto.RoleAuthDTO;
import com.xiumu.pojo.sys.model.query.RoleAuthQuery;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * dao 层方法命名尽量以 sql 语义命名，方法应当与业务无关
 * 插入 insertXXX
 * 更新 updateXXX
 * 查询 selectXXX
 * 删除 deleteXXX
 *
 * 角色权限关联 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Repository
public interface RoleAuthDao extends BaseMapper<RoleAuth> {

    /**
     * 分页查询
     * @param query 分页条件
     * @param roleAuth 查询条件
     * @return
     */
    IPage<RoleAuth> selectPage(PageQuery<RoleAuthQuery, RoleAuth> query, @Param("roleAuth") RoleAuthQuery roleAuth);

    /**
     * 根据条件查询 角色权限关联
     * @param roleAuth 查询条件
     * @return
     */
    List<RoleAuth> selectByRoleAuth(@Param("roleAuth") RoleAuthQuery roleAuth);

    /**
     * 根据 ID 更新 权限信息
     *
     * @param id           ID
     * @param roleAuth 权限信息, 空字段则不更新
     * @return
     */
    boolean updateById(@Param("id") Long id, @Param("roleAuth") RoleAuthDTO roleAuth);
}

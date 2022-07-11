package com.xiumu.springbootxiumu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.springbootxiumu.pojo.entity.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiumu
 */
@Repository
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 根据角色ID获取权限
     *
     * @param roleId 角色ID
     * @return
     */
    List<Authority> selectByRoleId(Long roleId);

    /**
     * 根据用户ID 查询所有的权限
     *
     * @param userId 用户
     * @return
     */
    List<Authority> selectByUserId(Long userId);
}

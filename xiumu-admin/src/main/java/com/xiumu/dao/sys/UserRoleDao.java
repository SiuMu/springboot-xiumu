package com.xiumu.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.pojo.sys.entity.UserRole;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联 Mapper 接口
 *
 * @author XiuMu
 * @date 2022-07-23 01:07:42
 */
@Repository
public interface UserRoleDao extends BaseMapper<UserRole> {
}

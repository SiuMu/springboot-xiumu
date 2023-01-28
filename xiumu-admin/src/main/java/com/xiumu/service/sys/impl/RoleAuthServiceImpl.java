package com.xiumu.service.sys.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.dao.sys.RoleAuthDao;
import com.xiumu.pojo.sys.dto.RoleAuthDTO;
import com.xiumu.pojo.sys.entity.RoleAuth;
import com.xiumu.service.sys.RoleAuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色权限关联 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthDao, RoleAuth> implements RoleAuthService {
    @Override
    @Transactional
    public boolean create(RoleAuthDTO roleAuthDTO) {
        RoleAuth roleAuth = BeanUtil.toBean(roleAuthDTO, RoleAuth.class);
        return this.save(roleAuth);
    }

    @Override
    public List<RoleAuth> listByRoleId(String roleId) {
        return list(new LambdaQueryWrapper<RoleAuth>().eq(RoleAuth::getRoleId, roleId));
    }
}

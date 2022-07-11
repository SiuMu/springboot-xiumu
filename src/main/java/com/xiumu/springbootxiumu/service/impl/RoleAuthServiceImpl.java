package com.xiumu.springbootxiumu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.mapper.RoleAuthMapper;
import com.xiumu.springbootxiumu.pojo.entity.RoleAuth;
import com.xiumu.springbootxiumu.service.RoleAuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiumu
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthMapper, RoleAuth> implements RoleAuthService {


    @Override
    public List<Long> findAuthIdByRoleId(Long roleId) {
        List<RoleAuth> authList = findByRoleId(roleId);
        return authList.stream().map(RoleAuth::getAuthId).collect(Collectors.toList());
    }

    @Override
    public List<RoleAuth> findByRoleId(Long roleId) {
        LambdaQueryWrapper<RoleAuth> queryWrapper = new LambdaQueryWrapper<RoleAuth>().eq(RoleAuth::getRoleId, roleId);
        return this.list(queryWrapper);
    }

    @Override
    @Transactional
    public boolean deleteByRoleId(Long roleId) {
        LambdaQueryWrapper<RoleAuth> queryWrapper = new LambdaQueryWrapper<RoleAuth>().eq(RoleAuth::getRoleId, roleId);
        return this.remove(queryWrapper);
    }

    @Override
    @Transactional
    public boolean createBatchByRoleIdAndAuthList(Long roleId, List<Long> authList) {
        List<RoleAuth> roleAuthList = new ArrayList<>();
        for (Long authId : authList) {
            roleAuthList.add(new RoleAuth(roleId, authId));
        }
        return this.saveBatch(roleAuthList);
    }
}

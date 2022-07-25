package com.xiumu.service.sys.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.common.core.enums.YesNo;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.dao.sys.RoleDao;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.model.dto.RoleDTO;
import com.xiumu.pojo.sys.model.query.RoleQuery;
import com.xiumu.service.sys.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Override
    public IPage<Role> listPage(PageQuery<RoleQuery, Role> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<Role> listByRole(RoleQuery role) {
        return this.baseMapper.selectByRole(role);
    }

    @Override
    public List<String> listRoleCodeByUserId(String userId) {
        List<Role> roles = this.baseMapper.selectByUserId(userId);
        return roles.stream().map(Role::getRoleCode).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean create(RoleDTO roleDTO) {
        Role role = BeanUtil.toBean(roleDTO, Role.class);
        return this.save(role);
    }

    @Override
    @Transactional
    public boolean updateById(RoleDTO roleDTO, String id) {
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        role.setId(id);
        return updateById(role);
    }

    @Override
    public boolean deleteById(String id) {
        LambdaUpdateWrapper<Role> updateWrapper = new LambdaUpdateWrapper<Role>()
                .set(Role::getDeleteFlag, YesNo.YES)
                .eq(Role::getId, id);
        return this.update(updateWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
     * @return
     */
    @Override
    public List<Role> list() {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>().eq(Role::getDeleteFlag, YesNo.
                NO);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
     * @return
     */
    public List<Role> list(LambdaQueryWrapper<Role> queryWrapper) {
        if (ObjectUtil.isNull(queryWrapper)) {
            queryWrapper = new LambdaQueryWrapper<Role>();
        }
        queryWrapper.eq(Role::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }
}

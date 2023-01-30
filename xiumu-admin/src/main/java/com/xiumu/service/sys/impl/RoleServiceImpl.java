package com.xiumu.service.sys.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.common.core.enums.YesNo;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.utils.AssertUtil;
import com.xiumu.dao.sys.RoleDao;
import com.xiumu.exception.user.RoleException;
import com.xiumu.pojo.sys.dto.RoleDTO;
import com.xiumu.pojo.sys.entity.Role;
import com.xiumu.pojo.sys.entity.RoleAuth;
import com.xiumu.pojo.sys.query.RoleQuery;
import com.xiumu.service.sys.RoleAuthService;
import com.xiumu.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private RoleAuthService roleAuthService;

    @Override
    public IPage<Role> listPage(PageQuery<RoleQuery, Role> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<Role> listByRole(RoleQuery role) {
        return this.baseMapper.selectByRole(role);
    }

    @Override
    public List<String> listRoleCodeByUserId(Long userId) {
        return listByUserId(userId).stream().map(Role::getRoleCode).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean create(RoleDTO roleDTO) {
        Role role = getByRoleCode(roleDTO.getRoleCode());
        AssertUtil.isNull(role, RoleException.CODE_EXIT);
        role = BeanUtil.toBean(roleDTO, Role.class);
        return this.save(role);
    }

    @Override
    @Transactional
    public boolean updateById(RoleDTO roleDTO, Long id) {
        Role role = new Role().setRoleName(roleDTO.getRoleName()).setRoleDesc(roleDTO.getRoleDesc());
        role.setId(id);
        return updateById(role);
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaUpdateWrapper<Role> updateWrapper = new LambdaUpdateWrapper<Role>()
                .set(Role::getDeleteFlag, YesNo.YES)
                .eq(Role::getId, id);
        return this.update(updateWrapper);
    }

    @Override
    public Role getByRoleCode(String roleCode) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>()
                .eq(Role::getRoleCode, roleCode)
                .eq(Role::getDeleteFlag, YesNo.NO);
        return getOne(queryWrapper);
    }

    @Override
    public List<Role> listByUserId(Long userId) {
        return this.baseMapper.selectByUserId(userId);
    }

    @Override
    public boolean setAuth(Long id, List<Long> authIdList) {
        Role role = getById(id);
        AssertUtil.isNotNull(role, RoleException.NOT_EXIT);
        AssertUtil.isTrue(CollectionUtil.isNotEmpty(authIdList), RoleException.EMPTY_AUTH);
        List<RoleAuth> roleAuthList = roleAuthService.listByRoleId(id);
        // 保留重复的，增加新增的
        List<Long> deleteIdList = new ArrayList<>();
        roleAuthList.forEach(roleAuth -> {
            if (authIdList.contains(roleAuth.getAuthId().toString())){
                // 重复的
                authIdList.remove(roleAuth.getAuthId().toString());
            }else {
                deleteIdList.add(roleAuth.getAuthId());
            }
        });
        List<RoleAuth> addList = authIdList.stream().map(auth -> new RoleAuth(id, auth)).collect(Collectors.toList());
        roleAuthService.removeBatchByIds(deleteIdList);
        return roleAuthService.saveBatch(addList);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
     * @return
     */
    @Override
    public List<Role> list() {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<Role>().eq(Role::getDeleteFlag, YesNo.NO);
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

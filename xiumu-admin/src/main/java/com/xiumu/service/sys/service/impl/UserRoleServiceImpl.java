package com.xiumu.service.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.pojo.sys.entity.UserRole;
import com.xiumu.pojo.sys.model.dto.UserRoleDTO;
import com.xiumu.pojo.sys.model.query.UserRoleQuery;
import com.xiumu.service.sys.dao.UserRoleDao;
import com.xiumu.service.sys.service.UserRoleService;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * 用户角色关联 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:28:18
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao,UserRole> implements UserRoleService {

    @Override
    public IPage<UserRole> listPage(PageQuery<UserRoleQuery, UserRole> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<UserRole> listByUserRole(UserRoleQuery userRole) {
        return this.baseMapper.selectByUserRole(userRole);
    }

    @Override
    @Transactional
    public boolean create(UserRoleDTO userRoleDTO) {
        UserRole userRole =BeanUtil.toBean(userRoleDTO, UserRole. class);
        return this.save(userRole);
    }

    @Override
    @Transactional
    public boolean updateById(UserRoleDTO userRoleDTO, Long id) {
        return this.baseMapper.updateById(id, userRoleDTO);
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaUpdateWrapper<UserRole> updateWrapper = new LambdaUpdateWrapper<UserRole>()
                .set(UserRole::getDeleteFlag, YesNo.YES)
                .eq(UserRole::getId, id);
        return this.update(updateWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     * @return
     */
    @Override
    public List<UserRole> list() {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<UserRole>().eq(UserRole::getDeleteFlag, YesNo.
        NO);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     * @return
     */
    public List<UserRole> list(LambdaQueryWrapper<UserRole> queryWrapper) {
        if (ObjectUtil.isNull(queryWrapper)) {
            queryWrapper = new LambdaQueryWrapper<UserRole>();
        }
        queryWrapper.eq(UserRole::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }
}

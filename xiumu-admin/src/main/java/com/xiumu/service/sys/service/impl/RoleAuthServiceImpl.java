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
import com.xiumu.pojo.sys.entity.RoleAuth;
import com.xiumu.pojo.sys.model.dto.RoleAuthDTO;
import com.xiumu.pojo.sys.model.query.RoleAuthQuery;
import com.xiumu.service.sys.dao.RoleAuthDao;
import com.xiumu.service.sys.service.RoleAuthService;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * 角色权限关联 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthDao,RoleAuth> implements RoleAuthService {

    @Override
    public IPage<RoleAuth> listPage(PageQuery<RoleAuthQuery, RoleAuth> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<RoleAuth> listByRoleAuth(RoleAuthQuery roleAuth) {
        return this.baseMapper.selectByRoleAuth(roleAuth);
    }

    @Override
    @Transactional
    public boolean create(RoleAuthDTO roleAuthDTO) {
        RoleAuth roleAuth =BeanUtil.toBean(roleAuthDTO, RoleAuth. class);
        return this.save(roleAuth);
    }

    @Override
    @Transactional
    public boolean updateById(RoleAuthDTO roleAuthDTO, Long id) {
        return this.baseMapper.updateById(id, roleAuthDTO);
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaUpdateWrapper<RoleAuth> updateWrapper = new LambdaUpdateWrapper<RoleAuth>()
                .set(RoleAuth::getDeleteFlag, YesNo.YES)
                .eq(RoleAuth::getId, id);
        return this.update(updateWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     * @return
     */
    @Override
    public List<RoleAuth> list() {
        LambdaQueryWrapper<RoleAuth> queryWrapper = new LambdaQueryWrapper<RoleAuth>().eq(RoleAuth::getDeleteFlag, YesNo.
        NO);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     * @return
     */
    public List<RoleAuth> list(LambdaQueryWrapper<RoleAuth> queryWrapper) {
        if (ObjectUtil.isNull(queryWrapper)) {
            queryWrapper = new LambdaQueryWrapper<RoleAuth>();
        }
        queryWrapper.eq(RoleAuth::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }
}

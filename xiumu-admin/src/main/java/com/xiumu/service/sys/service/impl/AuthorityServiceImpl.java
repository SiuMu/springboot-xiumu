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
import com.xiumu.pojo.sys.entity.Authority;
import com.xiumu.pojo.sys.model.dto.AuthorityDTO;
import com.xiumu.pojo.sys.model.query.AuthorityQuery;
import com.xiumu.service.sys.dao.AuthorityDao;
import com.xiumu.service.sys.service.AuthorityService;
import com.xiumu.common.core.page.PageQuery;

import java.util.List;

/**
 * 权限 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityDao,Authority> implements AuthorityService {

    @Override
    public IPage<Authority> listPage(PageQuery<AuthorityQuery, Authority> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<Authority> listByAuthority(AuthorityQuery authority) {
        return this.baseMapper.selectByAuthority(authority);
    }

    @Override
    @Transactional
    public boolean create(AuthorityDTO authorityDTO) {
        Authority authority =BeanUtil.toBean(authorityDTO, Authority. class);
        return this.save(authority);
    }

    @Override
    @Transactional
    public boolean updateById(AuthorityDTO authorityDTO, Long id) {
        return this.baseMapper.updateById(id, authorityDTO);
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaUpdateWrapper<Authority> updateWrapper = new LambdaUpdateWrapper<Authority>()
                .set(Authority::getDeleteFlag, YesNo.YES)
                .eq(Authority::getId, id);
        return this.update(updateWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     * @return
     */
    @Override
    public List<Authority> list() {
        LambdaQueryWrapper<Authority> queryWrapper = new LambdaQueryWrapper<Authority>().eq(Authority::getDeleteFlag, YesNo.
        NO);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     * @return
     */
    public List<Authority> list(LambdaQueryWrapper<Authority> queryWrapper) {
        if (ObjectUtil.isNull(queryWrapper)) {
            queryWrapper = new LambdaQueryWrapper<Authority>();
        }
        queryWrapper.eq(Authority::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }
}

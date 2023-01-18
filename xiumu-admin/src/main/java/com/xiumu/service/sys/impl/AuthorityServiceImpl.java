package com.xiumu.service.sys.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.common.core.enums.YesNo;
import com.xiumu.common.core.exception.base.IBaseExceptionImpl;
import com.xiumu.common.core.exception.sys.SysException;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.utils.AssertUtil;
import com.xiumu.common.core.utils.ValidatorUtils;
import com.xiumu.dao.sys.AuthorityDao;
import com.xiumu.enums.AuthType;
import com.xiumu.exception.user.AuthException;
import com.xiumu.pojo.sys.dto.AuthorityDTO;
import com.xiumu.pojo.sys.entity.Authority;
import com.xiumu.pojo.sys.entity.Menu;
import com.xiumu.pojo.sys.query.AuthorityQuery;
import com.xiumu.service.sys.AuthorityService;
import com.xiumu.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限 Service 业务层处理
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityDao, Authority> implements AuthorityService {

    @Autowired
    private MenuService menuService;

    @Override
    public IPage<Authority> listPage(PageQuery<AuthorityQuery, Authority> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<Authority> listByAuthority(AuthorityQuery authority) {
        return this.baseMapper.selectByAuthority(authority);
    }

    @Override
    public List<Authority> listByUserId(String userId) {
        return this.baseMapper.selectByUserId(userId);
    }

    @Override
    public List<String> listAuthCodeByUserId(String userId) {
        return listByUserId(userId).stream().map(Authority::getAuthCode).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean create(AuthorityDTO authorityDTO) {
        Authority authority = BeanUtil.toBean(authorityDTO, Authority.class);
        // 判断只有菜单才可以添加子级权限
        if (!authorityDTO.getParentId().equals("0")){
            Authority parent = getById(authorityDTO.getParentId());
            AssertUtil.isTrue(parent.getAuthType() == AuthType.MENU, AuthException.NOT_MENU);
        }
        // 如果添加的是菜单权限，对菜单信息进行手动校验, 再保存菜单
        if (authorityDTO.getAuthType() == AuthType.MENU){
            AssertUtil.isNotNull(authorityDTO.getMenu(), IBaseExceptionImpl.of(SysException.PARAM_ERROR.getCode(), "菜单信息不能为空"));
            ValidatorUtils.validate(authorityDTO.getMenu());
            Menu menu = BeanUtil.toBean(authorityDTO.getMenu(), Menu.class);
            menu.setAuthCode(authority.getAuthCode());
            menuService.save(menu);
        }
        return this.save(authority);
    }

    @Override
    @Transactional
    public boolean updateById(AuthorityDTO authorityDTO, String id) {
        Authority authority = BeanUtil.copyProperties(authorityDTO, Authority.class);
        authority.setId(id);
        menuService.updateByAuthCode(authorityDTO.getAuthCode(), authorityDTO.getMenu());
        return updateById(authority);
    }

    @Override
    public boolean deleteById(Long id) {
        LambdaUpdateWrapper<Authority> updateWrapper = new LambdaUpdateWrapper<Authority>()
                .set(Authority::getDeleteFlag, YesNo.YES)
                .eq(Authority::getId, id);
        return this.update(updateWrapper);
    }

    @Override
    public List<Authority> listByRoleId(String roleId) {
        return this.baseMapper.selectByRoleId(roleId);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
     * @return
     */
    @Override
    public List<Authority> list() {
        LambdaQueryWrapper<Authority> queryWrapper = new LambdaQueryWrapper<Authority>().eq(Authority::getDeleteFlag, YesNo.NO);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 重写 list 方法，查询未逻辑删除的记录
     *
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

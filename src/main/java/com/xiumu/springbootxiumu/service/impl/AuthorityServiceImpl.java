package com.xiumu.springbootxiumu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.enums.AuthType;
import com.xiumu.springbootxiumu.exception.user.AuthException;
import com.xiumu.springbootxiumu.mapper.AuthorityMapper;
import com.xiumu.springbootxiumu.pojo.dto.AuthorityDTO;
import com.xiumu.springbootxiumu.pojo.entity.Authority;
import com.xiumu.springbootxiumu.service.AuthorityService;
import com.xiumu.springbootxiumu.utils.AssertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiumu
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    @Override
    public List<Authority> getByUserId(String userId) {
        return this.baseMapper.selectByUserId(userId);
    }

    @Override
    public List<String> getAuthCodeByUserId(String userId) {
        return getByUserId(userId).stream().map(Authority::getAuthCode).collect(Collectors.toList());
    }

    @Override
    public Authority findByAuthCode(String authCode) {
        LambdaQueryWrapper<Authority> queryWrapper = new LambdaQueryWrapper<Authority>().eq(Authority::getAuthCode, authCode);
        return this.getOne(queryWrapper);
    }

    @Override
    @Transactional
    public boolean createAuthority(AuthorityDTO authDTO) {
        // 判断菜单才可以新建子级权限，按钮和接口不可以创建子级
        if (!authDTO.getParentId().equals(0L)) {
            Authority authority = this.getById(authDTO.getParentId());
            AssertUtil.notNull(authority, AuthException.NOT_EXIT);
            AssertUtil.isTrue(authority.getAuthType() == AuthType.MENU, AuthException.NOT_EXIT);
        }
        // 判断编码不能重复
        Authority authority = this.findByAuthCode(authDTO.getAuthCode());
        AssertUtil.isNull(authority, AuthException.REPEAT_CODE);
        authority = new Authority();
        BeanUtil.copyProperties(authDTO, authority);
        return this.save(authority);
    }
}

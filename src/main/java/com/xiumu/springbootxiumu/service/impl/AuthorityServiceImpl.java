package com.xiumu.springbootxiumu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.mapper.AuthorityMapper;
import com.xiumu.springbootxiumu.pojo.entity.Authority;
import com.xiumu.springbootxiumu.service.AuthorityService;
import org.springframework.stereotype.Service;

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
}

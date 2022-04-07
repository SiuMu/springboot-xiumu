package com.xiumu.springbootxiumu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.springbootxiumu.mapper.RoleAuthMapper;
import com.xiumu.springbootxiumu.pojo.entity.RoleAuth;
import com.xiumu.springbootxiumu.service.RoleAuthService;
import org.springframework.stereotype.Service;

/**
 * @author xiumu
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthMapper, RoleAuth> implements RoleAuthService {
}

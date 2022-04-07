package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.entity.Authority;

import java.util.List;

/**
 * @author xiumu
 */
public interface AuthorityService extends IService<Authority> {

    /**
     * 根据用户ID 查询所有的权限
     * @param userId 用户
     * @return
     */
    List<Authority> getByUserId(String userId);
}

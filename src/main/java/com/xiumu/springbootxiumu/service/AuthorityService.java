package com.xiumu.springbootxiumu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.springbootxiumu.pojo.dto.AuthorityDTO;
import com.xiumu.springbootxiumu.pojo.entity.Authority;

import java.util.List;

/**
 * @author xiumu
 */
public interface AuthorityService extends IService<Authority> {

    /**
     * 根据用户 ID 查询所有的权限
     *
     * @param userId 用户
     * @return
     */
    List<Authority> getByUserId(String userId);

    /**
     * 根据用户 ID 查询所有的权限编码
     *
     * @param userId 用户
     * @return
     */
    List<String> getAuthCodeByUserId(String userId);

    /**
     * 根据权限编码查询权限
     *
     * @param authCode 权限编码
     * @return
     */
    Authority findByAuthCode(String authCode);

    /**
     * 新增权限
     *
     * @param authDTO 权限信息
     * @return
     */
    boolean createAuthority(AuthorityDTO authDTO);
}

package com.xiumu.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.Authority;
import com.xiumu.pojo.sys.model.dto.AuthorityDTO;
import com.xiumu.pojo.sys.model.query.AuthorityQuery;

import java.util.List;

/**
 * 权限 Service 接口
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
public interface AuthorityService extends IService<Authority> {

    /**
     * 分页查询
     *
     * @param pageQuery 分页条件
     * @return
     */
    IPage<Authority> listPage(PageQuery<AuthorityQuery, Authority> pageQuery);

    /**
     * 根据条件查询 权限
     *
     * @param authority 查询条件
     * @return
     */
    List<Authority> listByAuthority(AuthorityQuery authority);

    /**
     * 创建 权限
     *
     * @param authorityDTO authority 信息
     * @return
     */
    boolean create(AuthorityDTO authorityDTO);

    /**
     * 更新 权限
     *
     * @param authorityDTO 更新内容
     * @param id           主键 ID
     * @return
     */
    boolean updateById(AuthorityDTO authorityDTO, Long id);

    /**
     * 根据 id 逻辑删除
     *
     * @param id id
     * @return
     */
    boolean deleteById(Long id);
}
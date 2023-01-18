package com.xiumu.service.sys;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.dto.MenuDTO;
import com.xiumu.pojo.sys.entity.Menu;
import com.xiumu.pojo.sys.query.MenuQuery;

import java.util.List;

/**
 * 菜单表，菜单与权限是一对一的关系 Service 接口
 *
 * @author XiuMu
 * @Date 2023-01-18 10:07:33
 */
public interface MenuService extends IService<Menu> {
    /**
     * 分页查询
     *
     * @param pageQuery 分页条件
     * @return
     */
    IPage<Menu> listPage(PageQuery<MenuQuery, Menu> pageQuery);

    /**
     * 根据条件查询 Menu
     *
     * @param menu 查询条件
     * @return
     */
    List<Menu> listByMenu(MenuQuery menu);

    /**
     * 根据权限集合查询对应的菜单信息
     * 并构建成树形结构
     *
     * @param authCodeList 权限集合
     * @return
     */
    List<Tree<String>> listByAuthCodeList(List<String> authCodeList);

    /**
     * 根据权限编码更新对应的菜单信息
     *
     * @param authCode 权限编码
     * @param menu     菜单信息
     * @return
     */
    boolean updateByAuthCode(String authCode, MenuDTO menu);
}

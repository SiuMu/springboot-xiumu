package com.xiumu.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.pojo.sys.entity.Menu;
import com.xiumu.pojo.sys.query.MenuQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单表，菜单与权限是一对一的关系 Mapper 接口
 *
 * @author XiuMu
 * @Date 2023-01-18 10:07:33
 */
@Service
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 分页查询
     *
     * @param query     分页条件
     * @param menu 查询条件
     * @return
     */
    IPage<Menu> selectPage(PageQuery<MenuQuery, Menu> query, @Param("authority") MenuQuery menu);

    /**
     * 根据条件查询 Menu
     *
     * @param menu 查询条件
     * @return
     */
    List<Menu> selectByMenu(@Param("menu") MenuQuery menu);
}
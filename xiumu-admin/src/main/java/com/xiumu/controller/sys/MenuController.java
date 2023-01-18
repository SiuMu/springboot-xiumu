package com.xiumu.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.result.ResultJSON;
import com.xiumu.pojo.sys.entity.Menu;
import com.xiumu.pojo.sys.query.MenuQuery;
import com.xiumu.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单表，菜单与权限是一对一的关系 Controller
 *
 * @author XiuMu
 * @Date 2023-01-18 10:07:33
 */
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 分页查询
     * 可传递查询参数，按照某些字段分页查询
     *
     * @param pageQuery 分页条件，查询参数
     * @return
     */
    @PostMapping("/page/menu")
    public ResultJSON<IPage<Menu>> page(@RequestBody PageQuery<MenuQuery, Menu> pageQuery) {
        return ResultJSON.querySuccess(menuService.listPage(pageQuery));
    }

    /**
    * 查询全部
    * 可传递查询参数，按照某些字段查询
    *
    * @param menu 查询条件
    * @return
    */
    @GetMapping("/menu")
    public ResultJSON<List<Menu>> list(MenuQuery menu) {
        List<Menu> menuList = menuService.listByMenu(menu);
        return ResultJSON.querySuccess(menuService.listByMenu(menu));
    }
}

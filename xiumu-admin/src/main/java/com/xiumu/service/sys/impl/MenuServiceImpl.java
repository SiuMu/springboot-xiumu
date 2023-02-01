package com.xiumu.service.sys.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.common.core.constants.XiuMuConst;
import com.xiumu.common.core.page.PageQuery;
import com.xiumu.common.core.tree.XiuMuTreeUtil;
import com.xiumu.dao.sys.MenuDao;
import com.xiumu.pojo.sys.dto.MenuDTO;
import com.xiumu.pojo.sys.entity.Menu;
import com.xiumu.pojo.sys.query.MenuQuery;
import com.xiumu.service.sys.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单表，菜单与权限是一对一的关系 Service 接口实现
 *
 * @author XiuMu
 * @Date 2023-01-18 10:07:33
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {
    @Override
    public IPage<Menu> listPage(PageQuery<MenuQuery, Menu> pageQuery) {
        return this.baseMapper.selectPage(pageQuery, pageQuery.getCondition());
    }

    @Override
    public List<Menu> listByMenu(MenuQuery menu) {
        return this.baseMapper.selectByMenu(menu);
    }

    @Override
    public List<Tree<Long>> listByAuthCodeList(List<String> authCodeList) {
        List<Menu> menuList = list(new LambdaQueryWrapper<Menu>().in(Menu::getAuthCode, authCodeList));
        return XiuMuTreeUtil.buildTree(menuList, XiuMuConst.ZERO_LONG);
    }

    @Override
    public boolean updateByAuthCode(String authCode, MenuDTO menuDTO) {
        Menu menu = BeanUtil.toBean(menuDTO, Menu.class);
        return update(menu, new LambdaUpdateWrapper<Menu>().eq(Menu::getAuthCode, authCode));
    }
}





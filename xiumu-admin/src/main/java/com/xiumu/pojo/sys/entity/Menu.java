package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.common.core.entity.BaseEntity;
import lombok.Data;

/**
 * 菜单表，菜单与权限是一对一的关系
 *
 * @author XiuMu
 */
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {
    /**
    * 父级菜单ID
    */
    private Long parentId;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 权限编码
    */
    private String authCode;
    /**
    * 前端path路径
    */
    private String menuPath;
    /**
    * 菜单图标
    */
    private String menuIcon;
    /**
    * 排序值
    */
    private Integer seq;
}

package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.common.core.entity.BaseEntity;
import lombok.Data;

/**
 * 菜单表，菜单与权限是一对一的关系
 *
 * @author XiuMu
 * @Date 2023-01-18 11:02:59
 */
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {
    /**
     * 父级菜单 ID
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单标题
     */
    private String menuTitle;
    /**
     * 权限编码
     * 编码不可更改
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private String authCode;
    /**
     * 前端 path 路径
     */
    private String menuPath;
    /**
     * 前端路由组件路径
     */
    private String component;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 排序权重，值越小越靠前
     */
    private Integer weight;
}

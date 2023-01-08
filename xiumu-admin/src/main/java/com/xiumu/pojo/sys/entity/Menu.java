package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.common.core.entity.BaseEntity;
import lombok.Data;

/**
* 
* @TableName sys_menu
*/
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {

    /**
    * 父级菜单ID
    */
    private String parentId;
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

package com.xiumu.pojo.sys.query;

import lombok.Data;

/**
 * 查询 菜单表，菜单与权限是一对一的关系 的传参对象
 *
 * @author XiuMu
 * @Date 2023-01-18 10:07:33
 */
@Data
public class MenuQuery {
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

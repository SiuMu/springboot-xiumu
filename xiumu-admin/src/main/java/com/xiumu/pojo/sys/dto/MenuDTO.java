package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 菜单 对象 DTO
 *
 * @author XiuMu
 * @Date 2023-01-18 11:02:59
 */
@Data
public class MenuDTO {
    /**
     * 父级菜单 ID
     */
    @NotNull(message = "父级菜单不能为空")
    private Long parentId;
    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    private String menuName;

    /**
     * 前端 path 路径
     */
    @NotBlank(message = "path 路径不能为空")
    private String menuPath;
    /**
     * 前端路由组件路径
     */
    private String component;
    /**
     * 菜单图标
     */
    private String menuIcon;
}

package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @Pattern(regexp = "^[A-Za-z]+", message = "菜单名称只允许输入英文字母")
    @NotBlank(message = "菜单名称不能为空")
    private String menuName;
    /**
     * 菜单标题
     */
    private String menuTitle;
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

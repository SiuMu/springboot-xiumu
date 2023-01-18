package com.xiumu.pojo.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "父级菜单不能为空")
    private String parentId;
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
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 排序权重，值越小越靠前
     */
    private Integer weight;
}

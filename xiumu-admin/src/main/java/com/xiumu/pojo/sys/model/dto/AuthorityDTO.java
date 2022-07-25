package com.xiumu.pojo.sys.model.dto;

import lombok.Data;

/**
 * 权限 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Data
public class AuthorityDTO {

    /**
     * 父级ID
     */
    private String parentId;
    /**
     * 权限编码
     */
    private String authCode;
    /**
     * 权限名称
     */
    private String authName;
    /**
     * 权限描述
     */
    private String authDesc;
    /**
     * 权限类型，0 菜单，1 按钮，2 接口
     */
    private Integer authType;

}


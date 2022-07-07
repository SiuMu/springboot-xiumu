package com.xiumu.springbootxiumu.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.springbootxiumu.enums.AuthType;
import com.xiumu.springbootxiumu.pojo.base.BaseEntity;
import lombok.Data;

/**
 * 权限
 *
 * @author xiumu
 */
@Data
@TableName("sys_authority")
public class Authority extends BaseEntity {

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
     * 权限类型：0菜单，1按钮，2接口
     */
    private AuthType authType;

}

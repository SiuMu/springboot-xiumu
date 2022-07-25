package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.common.core.entity.BaseEntity;
import com.xiumu.enums.AuthType;
import lombok.Data;

/**
 * Entity 表示与数据库一一对应的实体，不能出现数据库没有的字段。
 * 也不能与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解，都不能出现
 * <p>
 * 权限 对象 sys_authority
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Data
@TableName("sys_authority")
public class Authority extends BaseEntity {

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
    private AuthType authType;

}


package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.xiumu.common.core.entity.BaseEntity;

/**
 * Entity 表示与数据库一一对应的实体，不能出现数据库没有的字段。
 * 也不能与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解，都不能出现
 *
 * 角色 对象 sys_role
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Data
@TableName("sys_role")
public class Role extends BaseEntity{

/**
 *  角色名称
 */
private String roleName;
/**
 *  角色编码
 */
private String roleCode;
/**
 *  角色描述
 */
private String roleDesc;

}


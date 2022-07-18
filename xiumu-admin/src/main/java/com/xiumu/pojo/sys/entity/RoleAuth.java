package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.xiumu.common.core.entity.BaseEntity;

/**
 * Entity 表示与数据库一一对应的实体，不能出现数据库没有的字段。
 * 也不能与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解，都不能出现
 *
 * 角色权限关联 对象 sys_role_auth
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Data
@TableName("sys_role_auth")
public class RoleAuth extends BaseEntity{

/**
 *  角色ID
 */
private Long roleId;
/**
 *  权限ID
 */
private Long authId;

}


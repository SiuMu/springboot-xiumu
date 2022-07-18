package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.xiumu.common.core.entity.BaseEntity;

/**
 * Entity 表示与数据库一一对应的实体，不能出现数据库没有的字段。
 * 也不能与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解，都不能出现
 *
 * 用户角色关联 对象 sys_user_role
 *
 * @author XiuMu
 * @date 2022-07-16 17:28:18
 */
@Data
@TableName("sys_user_role")
public class UserRole extends BaseEntity{

/**
 *  用户ID
 */
private Long userId;
/**
 *  角色ID
 */
private Long roleId;

}


package com.xiumu.pojo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.common.core.entity.BaseEntity;
import com.xiumu.enums.Gender;
import lombok.Data;

/**
 * Entity 表示与数据库一一对应的实体，不能出现数据库没有的字段。
 * 也不能与数据库无关的注解或者方法，比如 POI 注解， 参数校验注解，都不能出现
 * <p>
 * 用户 对象 sys_user
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:37
 */
@Data
@TableName("sys_user")
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别，0男，1女，2未知
     */
    private Gender gender;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

}


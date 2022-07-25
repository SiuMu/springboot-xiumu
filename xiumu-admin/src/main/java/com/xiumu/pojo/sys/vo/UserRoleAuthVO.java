package com.xiumu.pojo.sys.vo;

import com.xiumu.enums.Gender;
import lombok.Data;

import java.util.List;

/**
 * 用户的信息，角色以及权限
 *
 * @Author XiuMu
 * @Date 2022/7/25
 **/
@Data
public class UserRoleAuthVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别，值为 1 时是男性，值为 2 时是女性，值为 0 时是未知
     */
    private Gender gender;

    /**
     * 角色列表
     */
    private List<String> roleList;

    /**
     * 权限列表
     */
    private List<String> authList;

}

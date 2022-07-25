package com.xiumu.pojo.sys.query;

import lombok.Data;

/**
 * Query 对象，表示查询传参，需要查询并传递参数的时候，封装成该对象
 *
 * 查询 角色 对象
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Data
public class RoleQuery {

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


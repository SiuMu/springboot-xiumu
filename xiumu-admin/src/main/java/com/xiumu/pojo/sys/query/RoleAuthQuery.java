package com.xiumu.pojo.sys.query;

import lombok.Data;

/**
 * Query 对象，表示查询传参，需要查询并传递参数的时候，封装成该对象
 *
 * 查询 角色权限关联 对象
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Data
public class RoleAuthQuery {

    /**
     *  角色ID
     */
    private Long roleId;
    /**
     *  权限ID
     */
    private Long authId;

}


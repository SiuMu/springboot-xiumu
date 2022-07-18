package com.xiumu.pojo.sys.model.query;

import lombok.Data;

/**
 * Query 对象，表示查询传参，需要查询并传递参数的时候，封装成该对象
 *
 * 查询 用户角色关联 对象
 *
 * @author XiuMu
 * @date 2022-07-16 17:28:18
 */
@Data
public class UserRoleQuery {

        /**
         *  用户ID
         */
        private Long userId;
        /**
         *  角色ID
         */
        private Long roleId;

}


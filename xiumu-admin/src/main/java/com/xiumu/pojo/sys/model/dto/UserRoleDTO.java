package com.xiumu.pojo.sys.model.dto;

import lombok.Data;

/**
 * DTO 数据传输对象，一般用作 add 或者 update 传参, 以及参数校验
 *
 * 用户角色关联 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:28:18
 */
@Data
public class UserRoleDTO {

        /**
         *  用户ID
         */
        private Long userId;
        /**
         *  角色ID
         */
        private Long roleId;

}


package com.xiumu.pojo.sys.model.dto;

import lombok.Data;

/**
 * DTO 数据传输对象，一般用作 add 或者 update 传参, 以及参数校验
 *
 * 角色权限关联 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:27:06
 */
@Data
public class RoleAuthDTO {

        /**
         *  角色ID
         */
        private Long roleId;
        /**
         *  权限ID
         */
        private Long authId;

}


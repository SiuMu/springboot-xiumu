package com.xiumu.pojo.sys.model.dto;

import lombok.Data;

/**
 * DTO 数据传输对象，一般用作 add 或者 update 传参, 以及参数校验
 *
 * 角色 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:52
 */
@Data
public class RoleDTO {

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


package com.xiumu.pojo.sys.model.dto;

import lombok.Data;

/**
 * DTO 数据传输对象，一般用作 add 或者 update 传参, 以及参数校验
 *
 * 权限 对象 DTO
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Data
public class AuthorityDTO {

        /**
         *  父级ID
         */
        private Long parentId;
        /**
         *  权限编码
         */
        private String authCode;
        /**
         *  权限名称
         */
        private String authName;
        /**
         *  权限描述
         */
        private String authDesc;
        /**
         *  权限类型，0菜单，1按钮，2接口
         */
        private Integer authType;

}


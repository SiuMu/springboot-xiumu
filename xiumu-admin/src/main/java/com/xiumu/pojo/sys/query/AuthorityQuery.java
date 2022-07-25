package com.xiumu.pojo.sys.query;

import lombok.Data;

/**
 * Query 对象，表示查询传参，需要查询并传递参数的时候，封装成该对象
 * <p>
 * 查询 权限 对象
 *
 * @author XiuMu
 * @date 2022-07-16 17:25:15
 */
@Data
public class AuthorityQuery {

    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 权限编码
     */
    private String authCode;
    /**
     * 权限名称
     */
    private String authName;
    /**
     * 权限描述
     */
    private String authDesc;
    /**
     * 权限类型，0菜单，1按钮，2接口
     */
    private Integer authType;

}


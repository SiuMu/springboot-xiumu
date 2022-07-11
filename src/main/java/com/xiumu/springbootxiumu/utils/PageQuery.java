package com.xiumu.springbootxiumu.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分页查询传参
 */
@Data
public class PageQuery<Q, T> extends Page<T> {

    /**
     * 查询条件
     */
    private Q condition;
}

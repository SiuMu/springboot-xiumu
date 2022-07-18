package com.xiumu.common.core.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分页查询传参
 *
 * @Author XiuMu
 * @Date 2022/7/16
 **/
@Data
public class PageQuery<Q, T> extends Page<T> {

    /**
     * 查询条件
     */
    private Q condition;

}

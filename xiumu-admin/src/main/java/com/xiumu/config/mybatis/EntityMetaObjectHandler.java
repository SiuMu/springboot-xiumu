package com.xiumu.config.mybatis;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 新增或修改的时候自动插入操作人 ID
 *
 * @Author XiuMu
 * @Date 2023/1/18 16:17
 **/
@Slf4j
@Component
public class EntityMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createBy",String.class, getLoginId());
        this.strictInsertFill(metaObject,"updateBy",String.class, getLoginId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"updateBy",String.class, getLoginId());
    }

    private String getLoginId() {
        String updateBy;
        try {
            updateBy = StpUtil.getLoginIdAsString();
        }catch (Exception e) {
            log.warn("新增或者修改的时候无法获取登录人ID", e);
            updateBy = "warn";
        }
        return updateBy;
    }
}
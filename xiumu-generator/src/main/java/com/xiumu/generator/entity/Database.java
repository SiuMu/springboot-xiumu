package com.xiumu.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiumu.generator.enums.DatabaseType;
import lombok.Data;

import java.util.Date;

/**
 * 数据库连接信息表
 *
 * @Author XiuMu
 * @Date 2022/8/11
 **/
@Data
@TableName("xiumu_database")
public class Database {

    /**
     * 主键
     * 提示：使用 Long 传递给前端会出现精度丢失问题
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据库名称
     */
    private String databaseName;

    /**
     * 数据库类型
     */
    private DatabaseType databaseType;

    /**
     * 数据源 key 唯一，不可重复，随机生成
     */
    private String dataSource;


    /**
     * 数据库连接的域名+端口号
     */
    private String ipPort;


    /**
     * 数据库用户名
     */
    private String username;


    /**
     * 数据库密码
     */
    private String password;

    public String getIpPort() {
        switch (databaseType) {
            case MYSQL:
                return ipPort + "/";
            case ORACLE:
                return ipPort + ":";
        }
        return ipPort;
    }
}

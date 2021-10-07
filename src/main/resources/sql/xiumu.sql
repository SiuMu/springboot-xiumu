create table sys_user
(
    id          bigint                             not null comment '主键ID'
        primary key,
    username    varchar(128)                       null comment '用户名',
    password    varchar(255)                       null comment '密码',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    delete_flag tinyint  default 0                 null comment '删除标记，0未删除，1已删除'
)
    comment '用户表';


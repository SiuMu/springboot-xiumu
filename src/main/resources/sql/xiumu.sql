create table sys_role
(
    id          bigint                             not null comment '主键ID'
        primary key,
    name        varchar(64)                        not null comment '角色名称',
    code        varchar(32)                        not null comment '角色编码',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    delete_flag tinyint  default 0                 null comment '删除标记，0未删除，1已删除'
)
    comment '角色表';

create table sys_user
(
    id          bigint                             not null comment '主键ID'
        primary key,
    username    varchar(128)                       null comment '用户名',
    password    varchar(255)                       null comment '密码',
    avatar      varchar(255)                       null comment '头像',
    gender      tinyint                            null comment '性别，0男，1女，2未知',
    phone       varchar(32)                        null comment '手机号',
    email       varchar(128)                       null comment '邮箱',
    role_code   varchar(32)                        null comment '用户所属角色',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    delete_flag tinyint  default 0                 null comment '删除标记，0未删除，1已删除'
)
    comment '用户表';


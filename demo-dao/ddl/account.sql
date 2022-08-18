create table `user_account`(
    `id` bigint(20) unsigned auto_increment comment 'id',
    `uid`  bigint(20) unsigned unique not null comment 'uid',
    `nickname` varchar(50) unique not null comment 'nickname',
    `password` varchar(200) not null comment 'nickname',
    `email` varchar(200) not null comment 'email',
    primary key(id)
)ENGINE=InnoDB  comment 'user account';

-- 用户账户体系设计
CREATE TABLE `account` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `uid` bigint(20) unsigned unique NOT NULL COMMENT 'uid',
    `email` varchar(127) unique NOT NULL COMMENT '用户邮箱',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `username` varchar(255) DEFAULT NULL COMMENT '用户名',
    `nickname` varchar(255) DEFAULT NULL COMMENT '用户名',
    `login_num` int(10) unsigned DEFAULT '0' COMMENT '登录次数',
    `last_login_time` datetime(3) DEFAULT NULL COMMENT '最后登录时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uid` (`uid`),
    UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户账户';

CREATE TABLE `role` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `name` varchar(50) NOT NULL COMMENT '角色名',
    `remark` varchar(255) DEFAULT NULL COMMENT '角色备注',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色';

CREATE TABLE `relate_account_role` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `uid` bigint(20) unsigned NOT NULL COMMENT 'uid',
    `role` varchar(50) NOT NULL COMMENT '角色',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_index` (`uid`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户';

create table `relate_role_permission`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `r_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
    `p_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
    unique key `uni_r_p_id` (`r_id`,`p_id`) USING BTREE
    primary key(id)
)ENGINE=InnoDB  comment 'role permission';

create table `permission`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `name` varchar(100) NOT NULL COMMENT '权限名',
    `remark` varchar(255) DEFAULT NULL COMMENT '权限备注',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

create table `account_group`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `db_create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '数据库插入时间',
    `db_modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库更新时间',
    `name` varchar(100) NOT NULL COMMENT '组名',
    `remark` varchar(255) DEFAULT NULL COMMENT '组备注',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户组';

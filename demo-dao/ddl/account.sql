create table `user_account`(
    `id` bigint(20) unsigned auto_increment comment 'id',
    `uid`  bigint(20) unsigned unique not null comment 'uid',
    `nickname` varchar(50) unique not null comment 'nickname',
    `password` varchar(200) not null comment 'nickname',
    `email` varchar(200) not null comment 'email',
    primary key(id)
)ENGINE=InnoDB  comment 'user account';
create table customer
(
	id bigint not null comment 'id',
	username varchar(10) not null comment '用户名',
	password varchar(32) not null comment '密码',
	answer varchar(128) not null comment '密保答案',
	question varchar(128) not null comment '找回密码问题',
	avatar varchar(128) null comment '头像地址',
	email varchar(32) not null comment '邮箱地址',
	age int null comment '年龄',
	sex tinyint default 1 null comment '1：男 2：女',
	points int null comment '积分',
	status tinyint default 1 not null comment '0：禁用 1：正常',
	login_time datetime null comment '上次登录时间',
	login_ip varchar(32) null comment '上次登录ip',
	create_time datetime not null comment '注册时间',
	modify_time datetime not null comment '用户信息修改时间',
	constraint customer_pk primary key (id)
)comment '顾客表' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
create unique index customer_email_uindex
	on customer (email);
create unique index customer_username_uindex
	on customer (username);




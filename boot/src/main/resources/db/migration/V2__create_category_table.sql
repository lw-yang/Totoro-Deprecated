create table category
(
	id bigint not null comment '目录id',
	name varchar(10) not null comment '目录名称',
	parent_id bigint default 0 null comment '父级目录id',
	create_time datetime null comment '创建时间',
	update_time datetime null comment '修改时间',
	constraint category_pk primary key (id)
)comment '商品目录表' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create unique index category_name_uindex on category (name);


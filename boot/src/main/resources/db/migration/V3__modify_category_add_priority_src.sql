alter table category
	add src varchar(128) null comment '类别展示的图片' after parent_id;

alter table category
	add priority int default 1 null comment '类别优先级，确定展示的顺序' after src;
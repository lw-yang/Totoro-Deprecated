CREATE TABLE `customer` (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `username` varchar(10) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `avatar` varchar(128) DEFAULT NULL COMMENT '用户头像地址',
  `email` varchar(32) DEFAULT NULL COMMENT '用户邮箱',
  `age` int(4) DEFAULT NULL COMMENT '用户年龄',
  `sex` tinyint(2) DEFAULT NULL COMMENT '用户性别 1:男 2:女',
  `points` int(4) DEFAULT NULL COMMENT '用户积分',
  `status` tinyint(2) NOT NULL COMMENT '用户状态 0：禁用 1：正常',
  `login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `login_ip` varchar(32) DEFAULT NULL COMMENT '上次登录ip地址',
  `create_time` datetime NOT NULL COMMENT '用户注册时间',
  `modify_time` datetime NOT NULL COMMENT '用户修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


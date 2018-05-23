CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mobile_number` bigint(11) unsigned NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `user_sex` varchar(8) NOT NULL COMMENT '性别',
  `email` varchar(30) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL COMMENT '校验码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_index` (`mobile_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
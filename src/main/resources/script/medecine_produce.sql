CREATE TABLE `medicine_produce` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `medicine_produce_id` varchar(30) NOT NULL COMMENT '生产批号',
  `medicine_fk` int(10) unsigned NOT NULL COMMENT '药品主键',
  `produce_man` bigint(11) NOT NULL COMMENT '生产业务员',
  `create_time` datetime NOT NULL COMMENT '生产日期',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '生产数量',
  `sale_num` int(11) DEFAULT '0' COMMENT '已销售数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
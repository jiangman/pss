CREATE TABLE `medicine_sale` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `enterpirs_id` int(11) NOT NULL COMMENT '药品批发企业',
  `medicine_produce_fk` varchar(30) NOT NULL COMMENT '药品生产批次',
  `num` int(11) NOT NULL COMMENT '出售药品数量',
  `sale_male` varchar(30) NOT NULL COMMENT '出售业务员',
  `sale_male_fk` int(10) NOT NULL COMMENT '销售业务员主键',
  `contract_code` varchar(30) NOT NULL COMMENT '订单编号',
  `delivery_address` varchar(1227) NOT NULL COMMENT '交货地址',
  `ransport_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1货车2轮船3航空',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1未完成2已完成',
  `delivery_date` datetime NOT NULL COMMENT '预定交货日期',
  `success_date` datetime NOT NULL COMMENT '实际交货日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
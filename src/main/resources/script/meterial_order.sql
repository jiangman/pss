CREATE TABLE `meterial_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `enterprise_id` int(10) NOT NULL COMMENT '供应商编号',
  `operation_date` datetime NOT NULL COMMENT '入库日期',
  `serial_no` varchar(255) NOT NULL COMMENT '入库单号',
  `salesman` varchar(255) NOT NULL COMMENT '业务员',
  `unit_price` double(12,2) NOT NULL COMMENT '单价',
  `number` double(12,2) NOT NULL COMMENT '数量',
  `size` tinyint(4) NOT NULL DEFAULT '2' COMMENT '单位，1为毫克，2位千克，3为吨',
  `sremark` varchar(1023) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
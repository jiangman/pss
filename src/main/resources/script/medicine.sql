CREATE TABLE `medicine` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(30) NOT NULL COMMENT '药品正式名称',
  `medicine_other_name` varchar(30) DEFAULT NULL COMMENT '药品通俗名称',
  `license_no` varchar(30) NOT NULL COMMENT '批准文号',
  `trade_price` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '批发价',
  `retail_price` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '建议零售价',
  `size_num` int(11) NOT NULL COMMENT '装箱数量',
  `size` varchar(30) NOT NULL COMMENT '药品规格，如‘138g*1瓶/盒’',
  `saveway` varchar(30) NOT NULL COMMENT '保存方法',
  `validity_period` tinyint(4) NOT NULL COMMENT '有效期，单位月',
  `picture_path` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `introduce` varchar(2047) DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `meterial` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `meterial_name` varchar(30) NOT NULL COMMENT '名称',
  `meterial_other_name` varchar(30) DEFAULT NULL COMMENT '别名',
  `meterial_size` tinyint(30) NOT NULL DEFAULT '2' COMMENT '单位，1为毫克，2位千克，3为吨',
  `saveway` varchar(30) NOT NULL COMMENT '保存方法',
  `enterprise_id` int(10) NOT NULL,
  `number` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '现有库存',
  `number_need` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '未完成订单',
  `picture_path` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `introduce` varchar(1023) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
CREATE TABLE `enterprise` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '企业id',
  `name` varchar(50) NOT NULL COMMENT '企业名称',
  `legal_person` varchar(30) NOT NULL COMMENT '法人代表',
  `contact_name` varchar(30) NOT NULL COMMENT '联系人姓名',
  `contact_mobile` bigint(11) NOT NULL COMMENT '联系人电话',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `address` varchar(127) NOT NULL COMMENT '地址',
  `social_credit_code` varchar(50) NOT NULL COMMENT '统一社会信用代码',
  `type` tinyint(4) NOT NULL DEFAULT '2' COMMENT '1药源供应商2药品批发商',
  `bank` tinyint(4) DEFAULT '2' COMMENT '1中国工商银行2中国银行',
  `bank_count` varchar(30) DEFAULT NULL COMMENT '银行账户',
  `tax_number` varchar(20) DEFAULT NULL COMMENT '税号',
  `drug_business` varchar(50) DEFAULT NULL COMMENT '药品经营许可证',
  `introduction` varchar(1023) DEFAULT NULL COMMENT '供应商简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `prescription` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `medicine_fk` int(10) unsigned NOT NULL COMMENT '药品主键',
  `meterial_fk` int(10) unsigned NOT NULL COMMENT '药材主键',
  `num` double(12,2) NOT NULL DEFAULT '0.00' COMMENT '用量',
  `size` tinyint(4) NOT NULL DEFAULT '2' COMMENT '单位，1为毫克，2位克，3为千克，4为吨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
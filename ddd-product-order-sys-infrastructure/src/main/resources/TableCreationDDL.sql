use itdotaer;

CREATE TABLE `product_info` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_name` varchar(1024) NOT NULL COMMENT '产品名称',
  `online` bit(1) NOT NULL COMMENT '在线',
  `active` bit(1) NOT NULL COMMENT '有效',
  `status` tinyint(2) DEFAULT NULL COMMENT '',
  `creator` varchar(64) NOT NULL COMMENT '创建人',
  `modifier` varchar(64) NOT NULL COMMENT '修改人',
  `gmt_create` datetime(3) NOT NULL COMMENT '创建时间' DEFAULT CURRENT_TIMESTAMP(3),
  `gmt_modified` datetime(3) NOT NULL COMMENT '修改时间' DEFAULT CURRENT_TIMESTAMP(3),
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '逻辑删除',
  PRIMARY KEY (`product_id`),
  KEY `idx_product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

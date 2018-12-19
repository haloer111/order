-- ----------------------------
--  Table structure for `order_info_tb`
-- ----------------------------
DROP TABLE IF EXISTS `order_info_tb`;
CREATE TABLE `order_info_tb` (
  `order_id` varchar(200) DEFAULT NULL COMMENT '订单id',
  `customer_id` varchar(200) DEFAULT NULL COMMENT '买家id',
  `type` int(8) DEFAULT NULL COMMENT '订单类型',
  `status` varchar(100) DEFAULT NULL COMMENT '订单状态（支付、完成（即消费）...）',
  `valida_start_time` datetime DEFAULT NULL COMMENT '订单有效期-开始日期',
  `valida_end_time` datetime DEFAULT NULL COMMENT '订单有效期-结束日期',
  `permit_start_time` datetime DEFAULT NULL COMMENT '允许使用时间--开始时间',
  `permit_end_time` datetime DEFAULT NULL COMMENT '允许使用时间--结束时间',
  `is_refund` tinyint(1) DEFAULT NULL COMMENT '是否完成退款',
  `rule` varchar(64) DEFAULT NULL COMMENT '订单使用规则',
  `refund_rule` int(8) DEFAULT NULL COMMENT '退单规则（随时退、过期自动退、手工退、不允许退）',
  `order_desc` varchar(128) DEFAULT NULL COMMENT '订单描述',
  `order_remark` varchar(64) DEFAULT NULL COMMENT '订单备注',
  `address` varchar(256) DEFAULT NULL COMMENT '收货地址',
  `express_no` varchar(64) DEFAULT NULL COMMENT '快递单号',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `total_price` decimal(20,2) DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
  `dues` decimal(20,2) DEFAULT NULL COMMENT '实付金额',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
--  Table structure for `order_detail_tb`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail_tb`;
CREATE TABLE `order_detail_tb` (
  `id` varchar(200) NOT NULL,
  `order_id` varchar(200) NOT NULL COMMENT '订单id',
  `goods_id` varchar(200) DEFAULT NULL COMMENT '商品id',
  `sale_price` decimal(20,2) DEFAULT NULL COMMENT '销售价格',
  `quantity` int(8) DEFAULT NULL COMMENT '数量',
  `unit` varchar(16) DEFAULT NULL COMMENT '价格单位',
  `adjust_price` decimal(20,2) DEFAULT NULL COMMENT '调整后价格（如参加促销活动...）',
  `sale_promotion_id` varchar(256) DEFAULT NULL COMMENT '商品参加的促销活动',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
package com.aojing.redstore.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/18 10:40
 */
@Data
public class OrderVo {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家id
     */
    private String userId;

    /**
     * 合计数
     */
    private int totalCount;
    /**
     * 手机号
     */
    private String number;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;

    /**
     * 商品详情vo集合
     */
    List<OrderDetailVo> orderDetailVoList;
}

package com.aojing.redstore.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gexiao
 * @date 2018/12/26 16:28
 */
@Data
public class OrderMiniVo {
    /**
     * order_id
     */
    private String id;

    /**
     * 订单备注
     */
    private String orderRemark;
    /**
     * 下单时间
     */
    private Date validaStartTime;
    /**
     * 截止时间
     */
    private Date validaEndTime;

    /**
     * 数量
     */
    private int count;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 产品略缩图
     */
    private String slightlyThumbnail;

    /**
     * 订单状态
     */
    private String status;


}

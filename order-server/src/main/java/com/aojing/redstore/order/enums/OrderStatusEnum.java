package com.aojing.redstore.order.enums;

import lombok.Getter;

/**
 * @author gexiao
 * @date 2018/12/19 16:19
 */
@Getter
public enum  OrderStatusEnum {


    PREORDER(10, "刚下单"),
    PAYED(20, "订单已支付"),
    COMPLETED(30,"订单已完成"),
    CANCELED(40,"订单已取消"),
    CANCELLING(50,"正在取消订单"),
    REFUNDED(60,"已退款"),
    USED(70,"订单已被使用"),
    DELETED(80,"订单已删除"),
    UNCOMMENT(90,"订单未评论"),


    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

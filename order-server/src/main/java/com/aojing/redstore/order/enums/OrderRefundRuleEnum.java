package com.aojing.redstore.order.enums;

import lombok.Getter;

/**
 * @author gexiao
 * @date 2018/12/19 16:29
 */
@Getter
public enum OrderRefundRuleEnum {

    ANYTIME(10, "随时退"),
    OVERDUE(20, "过（有效）期退"),
    MANUAL(30,"手工退"),
    INADMISSIBLE(40,"不允许退"),


    ;

    private Integer code;

    private String message;

    OrderRefundRuleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

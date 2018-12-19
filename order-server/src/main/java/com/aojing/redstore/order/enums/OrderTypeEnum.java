package com.aojing.redstore.order.enums;

import lombok.Getter;

/**
 * @author gexiao
 * @date 2018/12/19 16:14
 */
@Getter
public enum OrderTypeEnum {

    NET(10, "网络"),
    QR_CODE(20, "二维码"),
    APP(30,"手机下单"),


    ;

    private Integer code;

    private String message;

    OrderTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}




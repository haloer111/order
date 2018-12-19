package com.aojing.redstore.order.enums;

import lombok.Getter;


/**
 * 全局异常类枚举
 * 返回码说明:
 * 0[0-1] 0代表成功值,1代表失败值
 * 0[0-9] 代表异常的大类
 * 00[00-99] 代表异常的微服务项目
 * 000[000-999] 代表具体异常码
 *
 * @author gexiao
 * @date 2018/12/5 9:57
 */
@Getter
public enum OrderExceptionEnum {

    CREATE_ORDER_FAIL(1103001, "创建订单失败"),



    ;

    private Integer code;

    private String message;

    OrderExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

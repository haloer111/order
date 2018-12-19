package com.aojing.redstore.order.exception;

import com.aojing.redstore.order.enums.OrderExceptionEnum;
import lombok.Getter;


@Getter
public class RedStoreException extends RuntimeException{

    private Integer code;

    public RedStoreException(OrderExceptionEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public RedStoreException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

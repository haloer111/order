package com.aojing.redstore.order.exception;

import com.aojing.redstore.order.enums.OrderExceptionEnum;
import lombok.Getter;


@Getter
public class ServiceException extends RuntimeException{

    private Integer code;

    public ServiceException(OrderExceptionEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

package com.aojing.redstore.order.form;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.security.KeyStore;

/**
 * @author gexiao
 * @date 2018/12/18 10:44
 */
@Data
public class OrderForm {
    @NotEmpty(message = "商品id不能为空")
    private String goodsId;
    @NotEmpty(message = "商品数量不能为空")
    private int goodsCount;

    private String number;
}

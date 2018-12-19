package com.aojing.redstore.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author gexiao
 * @date 2018/12/18 10:15
 */
@Data
public class OrderDetailVo {
    /**
     * 卖家id
     */
    private String sellerId;
    /**
     * 商店名称
     */
    private String storeName;
    /**
     * 商品数量
     */
    private int goodsCount;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品id
     */
    private String goodsId;




}

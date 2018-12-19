package com.aojing.redstore.order.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("order_detail_tb")
public class OrderDetail {
    private String id;

    private String orderId;

    private String goodsId;

    private BigDecimal salePrice;

    private Integer quantity;

    private String unit;

    private BigDecimal adjustPrice;

    private String salePromotionId;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getAdjustPrice() {
        return adjustPrice;
    }

    public void setAdjustPrice(BigDecimal adjustPrice) {
        this.adjustPrice = adjustPrice;
    }

    public String getSalePromotionId() {
        return salePromotionId;
    }

    public void setSalePromotionId(String salePromotionId) {
        this.salePromotionId = salePromotionId == null ? null : salePromotionId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
package com.aojing.redstore.order.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("order_info_tb")
public class OrderInfo {
    private String id;

    private String customerId;

    private Integer type;

    private String status;

    private Date validaStartTime;

    private Date validaEndTime;

    private Date permitStartTime;

    private Date permitEndTime;

    private Boolean isRefund;

    private String rule;

    private Integer refundRule;

    private String orderDesc;

    private String orderRemark;

    private String address;

    private String expressNo;

    private Date deliveryTime;

    private Date receiveTime;

    private BigDecimal totalPrice;

    private BigDecimal dues;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getValidaStartTime() {
        return validaStartTime;
    }

    public void setValidaStartTime(Date validaStartTime) {
        this.validaStartTime = validaStartTime;
    }

    public Date getValidaEndTime() {
        return validaEndTime;
    }

    public void setValidaEndTime(Date validaEndTime) {
        this.validaEndTime = validaEndTime;
    }

    public Date getPermitStartTime() {
        return permitStartTime;
    }

    public void setPermitStartTime(Date permitStartTime) {
        this.permitStartTime = permitStartTime;
    }

    public Date getPermitEndTime() {
        return permitEndTime;
    }

    public void setPermitEndTime(Date permitEndTime) {
        this.permitEndTime = permitEndTime;
    }

    public Boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public Integer getRefundRule() {
        return refundRule;
    }

    public void setRefundRule(Integer refundRule) {
        this.refundRule = refundRule;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc == null ? null : orderDesc.trim();
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDues() {
        return dues;
    }

    public void setDues(BigDecimal dues) {
        this.dues = dues;
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
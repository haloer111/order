package com.aojing.redstore.order.service;

import com.aojing.redstore.order.pojo.OrderInfo;

/**
 * @author gexiao
 * @date 2018/12/17 11:31
 */
public interface IOrderManagerService {
    /**
     * 下单（购买）
     */
  //  public OrderInfo create(Buyer Buyer, GoodsInfo goods);

    /**
     * 识别订单二维码
     */
   // public OrderInfo RecognizeQRCode(object obj);



    /**
     * 取消订单
     */
    public boolean cancel(OrderInfo order);

    /**
     * 删除订单
     */
    public boolean delete(OrderInfo order);

    /**
     * 修改订单信息
     */
    public boolean updata(OrderInfo order);

    /**
     * 导出订单信息
     */
    public boolean export(String exportFile);

    /**
     * 退单（取消订单并退款）
     */
    public boolean refund(OrderInfo order);

    /**
     * 查询订单信息
     */
  //  public OrderInfo query(Buyer orderID);

    /**
     * 根据商品调整后价格（即考虑促销活动后计算出来的价格）统计总金额
     */
    public float totalGoodsAdjuctAmount(OrderInfo order);

    /**
     * 统计应付款（运费+商品总额）
     */
    public float totalDues(OrderInfo order);

    /**
     * 统计运费
     */
    public float totalFreight(OrderInfo order);

}

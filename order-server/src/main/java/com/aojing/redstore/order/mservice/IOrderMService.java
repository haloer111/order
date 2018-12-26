package com.aojing.redstore.order.mservice;

import com.aojing.redstore.order.common.Result;
import com.aojing.redstore.order.vo.OrderMiniVo;
import com.aojing.redstore.order.vo.OrderVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/18 9:31
 */
public interface IOrderMService {


    /**
     * 创建订单
     * @param orderVo
     * @return
     */
    public Result<OrderVo> create(OrderVo orderVo);

    /**
     * 修改订单的数量
     * @param orderVo
     * @return 调整后的价格
     */
    public Result<BigDecimal> updateOrderCount(OrderVo orderVo);

    /**
     * 查询全部订单根据状态
     * @param status
     * @return
     */
    List<OrderMiniVo> queryOrderList(String status);
}

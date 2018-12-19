package com.aojing.redstore.order.dao;

import com.aojing.redstore.order.pojo.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);
}
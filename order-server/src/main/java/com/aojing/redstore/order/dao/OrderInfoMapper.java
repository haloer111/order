package com.aojing.redstore.order.dao;

import com.aojing.redstore.order.pojo.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);
}
package com.aojing.redstore.order.dao;

import com.aojing.redstore.order.pojo.OrderInfo;
import com.aojing.redstore.order.vo.OrderMiniVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    int deleteByPrimaryKey(String id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderMiniVo> selectByStatus(@Param("statusList") List<String> statusList);

}
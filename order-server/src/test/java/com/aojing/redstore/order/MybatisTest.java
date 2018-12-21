package com.aojing.redstore.order;

import com.aojing.redstore.order.dao.OrderDetailMapper;
import com.aojing.redstore.order.pojo.OrderDetail;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/19 14:07
 */
public class MybatisTest extends OrderServerApplicationTests{

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void test(){
        QueryWrapper<OrderDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id","1330e625f5514b4f9677e18d9f0b7aac");
       // queryWrapper.eq("unit",5);
        OrderDetail orderDetailMappers = orderDetailMapper.selectOne(queryWrapper);
        Assert.assertNotNull(orderDetailMappers);
    }
}

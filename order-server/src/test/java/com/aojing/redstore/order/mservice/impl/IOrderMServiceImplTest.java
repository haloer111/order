package com.aojing.redstore.order.mservice.impl;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.aojing.redstore.order.common.Result;
import com.aojing.redstore.order.pojo.OrderDetail;
import com.aojing.redstore.order.vo.OrderDetailVo;
import com.google.common.collect.Lists;

import com.aojing.redstore.order.OrderServerApplicationTests;
import com.aojing.redstore.order.vo.OrderVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author gexiao
 * @date 2018/12/19 16:33
 */
public class IOrderMServiceImplTest extends OrderServerApplicationTests {



    @Autowired
    private IOrderMServiceImpl iOrderMService;
    @Test
    public void create() {
        List<OrderDetailVo> list = new ArrayList<>();
        OrderDetailVo orderDetailVo = new OrderDetailVo();
        orderDetailVo.setSellerId("123");
        orderDetailVo.setStoreName("测试商店");
        orderDetailVo.setGoodsCount(2);
        orderDetailVo.setGoodsImg("http://www.xxx.com");
        orderDetailVo.setGoodsId("56324235656465d4df2312");
        list.add(orderDetailVo);
        OrderDetailVo orderDetailVo1 = new OrderDetailVo();
        orderDetailVo1.setSellerId("123");
        orderDetailVo1.setStoreName("测试商店");
        orderDetailVo1.setGoodsCount(1);
        orderDetailVo1.setGoodsImg("http://www.xxx.com");
        orderDetailVo1.setGoodsId("56873f9d9f5d34532254645444273865685goods");
        list.add(orderDetailVo1);


        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId("");
        orderVo.setUserId("user1");
        orderVo.setOrderDetailVoList(list);

        Result<OrderVo> orderVoResult = iOrderMService.create(orderVo);

        Assert.assertNotNull(orderVoResult);
    }
}
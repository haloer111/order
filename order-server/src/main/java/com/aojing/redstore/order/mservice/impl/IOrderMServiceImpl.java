package com.aojing.redstore.order.mservice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.aojing.redstore.order.common.Result;
import com.aojing.redstore.order.dao.OrderDetailMapper;
import com.aojing.redstore.order.dao.OrderInfoMapper;
import com.aojing.redstore.order.enums.OrderRefundRuleEnum;
import com.aojing.redstore.order.enums.OrderStatusEnum;
import com.aojing.redstore.order.enums.OrderTypeEnum;
import com.aojing.redstore.order.exception.ServiceException;
import com.aojing.redstore.order.mservice.IOrderMService;
import com.aojing.redstore.order.pojo.OrderDetail;
import com.aojing.redstore.order.pojo.OrderInfo;
import com.aojing.redstore.order.service.feign.GoodsClient;
import com.aojing.redstore.order.service.feign.common.DecreaseStockInput;
import com.aojing.redstore.order.util.BigDecimalUtil;
import com.aojing.redstore.order.util.KeyUtil;
import com.aojing.redstore.order.vo.GoodsInfoVo;
import com.aojing.redstore.order.vo.OrderDetailVo;
import com.aojing.redstore.order.vo.OrderMiniVo;
import com.aojing.redstore.order.vo.OrderVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.aojing.redstore.order.enums.OrderExceptionEnum.UPDATE_ORDERDETAIL_FAIL;

/**
 * @author gexiao
 * @date 2018/12/18 9:35
 */
@Service
public class IOrderMServiceImpl implements IOrderMService {

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Transactional
    public Result<OrderVo> create(OrderVo orderVo) {
        BigDecimal totalPrice = new BigDecimal("0");
        int totalCount = 0;
        String orderId = KeyUtil.getkey();
        // 1.获取商品id,查询商品集合
        List<OrderDetailVo> orderDetailVoList = orderVo.getOrderDetailVoList();
        List<String> goodsIdList =
                orderDetailVoList.stream().map(e -> e.getGoodsId()).collect(Collectors.toList());

        // 2.调用媒体服务查询图片
        List<GoodsInfoVo> goodsInfoVos = goodsClient.queryGoodsByIds(goodsIdList);
        for (OrderDetailVo detailVo : orderDetailVoList) {
            for (GoodsInfoVo infoVo : goodsInfoVos) {
                if (StringUtils.equals(infoVo.getGoodsId(), detailVo.getGoodsId())) {
                    //给图片赋值
                    detailVo.setGoodsImg(infoVo.getSlightlyThumbnail().get(0));
                    // 3.计算总价
                    totalPrice =
                            BigDecimalUtil.add(BigDecimalUtil.mul(
                                    Double.valueOf(String.valueOf(detailVo.getGoodsCount())),
                                    infoVo.getPrice().doubleValue()).doubleValue(),
                                    totalPrice.doubleValue());
                    // 商品总数
                    totalCount = totalCount + detailVo.getGoodsCount();
                    // 5.生成订单明细
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setId(KeyUtil.getkey());
                    orderDetail.setOrderId(orderId);
                    orderDetail.setGoodsId(detailVo.getGoodsId());
                    orderDetail.setSalePrice(infoVo.getPrice());
                    orderDetail.setQuantity(detailVo.getGoodsCount());
                    orderDetail.setUnit("元");
                    orderDetail.setAdjustPrice(new BigDecimal("0"));
                    orderDetail.setSalePromotionId("");
                    orderDetail.setCreateTime(new Date());

                    orderDetailMapper.insert(orderDetail);
                }
            }
        }
        //返回对象赋值
        orderVo.setTotalPrice(totalPrice);
        orderVo.setTotalCount(totalCount);
        orderVo.setOrderId(orderId);
        orderVo.setNumber("123123212131");

        // 4.扣减库存
        List<DecreaseStockInput> decreaseStockInputList = new ArrayList<>();
               /* orderDetailVoList.stream().map(e -> new DecreaseStockInput(e.getGoodsId(),
                        e.getGoodsCount())).collect(Collectors.toList());*/
        for (OrderDetailVo orderDetailVo : orderDetailVoList) {
            DecreaseStockInput input = new DecreaseStockInput();
            input.setGoodsId(orderDetailVo.getGoodsId());
            input.setGoodsCount(orderDetailVo.getGoodsCount());
            decreaseStockInputList.add(input);
        }

        goodsClient.decreaseStock(decreaseStockInputList);

        // 6.生成订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderId);
        orderInfo.setCustomerId(orderVo.getUserId());
        orderInfo.setType(OrderTypeEnum.APP.getCode());
        orderInfo.setStatus(OrderStatusEnum.PREORDER.getCode().toString());
        orderInfo.setValidaStartTime(new Date());
        orderInfo.setValidaEndTime(new Date());
        orderInfo.setPermitStartTime(new Date());
        orderInfo.setPermitEndTime(new Date());
        orderInfo.setIsRefund(false);
        orderInfo.setRule("");
        orderInfo.setRefundRule(OrderRefundRuleEnum.OVERDUE.getCode());
        orderInfo.setOrderDesc("");
        orderInfo.setOrderRemark("");
        orderInfo.setAddress("");
        orderInfo.setExpressNo("");
        orderInfo.setDeliveryTime(new Date());
        orderInfo.setReceiveTime(new Date());
        orderInfo.setTotalPrice(totalPrice);
        orderInfo.setDues(new BigDecimal("0"));
        orderInfo.setCreateTime(new Date());


        orderInfoMapper.insert(orderInfo);

        return Result.createBySuccess(orderVo);
    }

    public Result<BigDecimal> updateOrderCount(OrderVo orderVo) {
        //1.获取订单id,商品id,数量
        List<OrderDetailVo> orderDetailVoList = orderVo.getOrderDetailVoList();
        //2.查询是否存在该订单
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq("id", orderVo.getOrderId());
        OrderInfo orderInfo = orderInfoMapper.selectOne(queryWrapper);

        List<String> goodsIdList =
                orderDetailVoList.stream().map(e -> e.getGoodsId()).collect(Collectors.toList());
        // 2.调用媒体服务查询图片
        List<GoodsInfoVo> goodsInfoVos = goodsClient.queryGoodsByIds(goodsIdList);

        //总价格
        BigDecimal totalPrice = orderInfo.getTotalPrice();
        if (orderInfo != null) {
            //3.扣减库存
            List<DecreaseStockInput> decreaseStockInputList =
                    orderDetailVoList.stream().map(e -> new DecreaseStockInput(e.getGoodsId(),
                            e.getGoodsCount())).collect(Collectors.toList());
            goodsClient.decreaseStock(decreaseStockInputList);

            //4.修改订单详情
            for (OrderDetailVo orderDetailVo : orderDetailVoList) {
                for (GoodsInfoVo goodsInfoVo : goodsInfoVos) {
                    if (orderDetailVo.getGoodsId().equals(goodsInfoVo.getGoodsId())) {
                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setQuantity(orderDetailVo.getGoodsCount());
                        UpdateWrapper<OrderDetail> updateWrapper = new UpdateWrapper();
                        updateWrapper.lambda().eq(OrderDetail::getGoodsId, orderDetail.getGoodsId())
                                .eq(OrderDetail::getGoodsId, orderDetail.getOrderId());
                        int updateResult = orderDetailMapper.update(orderDetail, updateWrapper);
                        if (updateResult < 0) {
                            throw new ServiceException(UPDATE_ORDERDETAIL_FAIL);
                        }
                        totalPrice = BigDecimalUtil.add(goodsInfoVo.getPrice().doubleValue(), totalPrice
                                .doubleValue());
                    }

                }

            }

            //5.修改订单
            OrderInfo updateOrder = new OrderInfo();
            updateOrder.setId(orderVo.getOrderId());
            updateOrder.setTotalPrice(totalPrice);
            int updateResult = orderInfoMapper.updateById(updateOrder);
            if (updateResult < 0) {
                throw new ServiceException(UPDATE_ORDERDETAIL_FAIL);
            }
        }

        return Result.createBySuccess(totalPrice);
    }

    @Override
    public List<OrderMiniVo> queryOrderList(String status) {

        //查询全部商品
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper();

        List<OrderMiniVo> orderMiniVoList =
                orderInfoMapper.selectByStatus(Arrays.asList(OrderStatusEnum.COMPLETED.getCode().toString()
                , OrderStatusEnum.REFUNDED.getCode().toString()
                , OrderStatusEnum.PAYED.getCode().toString()
                , OrderStatusEnum.UNCOMMENT.getCode().toString()));


        return orderMiniVoList;
    }

}

package com.aojing.redstore.order.ctrl;

import com.aojing.redstore.order.common.Result;
import com.aojing.redstore.order.convert.OrderForm2OrderVoConvert;
import com.aojing.redstore.order.enums.OrderExceptionEnum;
import com.aojing.redstore.order.exception.ServiceException;
import com.aojing.redstore.order.form.OrderForm;
import com.aojing.redstore.order.mservice.IOrderMService;
import com.aojing.redstore.order.vo.OrderMiniVo;
import com.aojing.redstore.order.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/18 10:51
 */
@RestController
@RequestMapping("api/order")
@Slf4j
public class OrderCtrl {

    @Autowired
    private IOrderMService iOrderMService;

    @PostMapping("create")
    public Result<OrderVo> create(@Valid OrderForm form, BindingResult result) {
        if (result.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", form);
            throw new ServiceException(OrderExceptionEnum.CREATE_ORDER_FAIL);
        }
        OrderVo orderVo = OrderForm2OrderVoConvert.convert(form, new OrderVo());
        return iOrderMService.create(orderVo);
    }

    @PostMapping("update")
    public Result<BigDecimal> update(@RequestParam OrderVo orderVo) {
        return iOrderMService.updateOrderCount(orderVo);
    }

    @GetMapping("queryOrderList")
    public List<OrderMiniVo> queryOrderList(@RequestParam("status")String status){
        List<OrderMiniVo> orderMiniVoList= iOrderMService.queryOrderList(status);
        return null;
    }
}

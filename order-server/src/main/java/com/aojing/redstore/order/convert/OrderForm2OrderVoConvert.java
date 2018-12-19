package com.aojing.redstore.order.convert;

import com.aojing.redstore.order.form.OrderForm;
import com.aojing.redstore.order.vo.OrderVo;
import org.springframework.beans.BeanUtils;

/**
 * @author gexiao
 * @date 2018/12/18 11:03
 */
public class OrderForm2OrderVoConvert {

    public static OrderVo convert(OrderForm form, OrderVo orderVo) {

        BeanUtils.copyProperties(form, orderVo.getOrderDetailVoList());
        orderVo.setNumber(form.getNumber());
        return orderVo;
    }
}

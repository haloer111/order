package com.aojing.redstore.order.service.feign;

import com.aojing.redstore.order.service.feign.common.DecreaseStockInput;
import com.aojing.redstore.order.vo.GoodsInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/19 10:17
 */
@FeignClient(name = "service-goods")
public interface GoodsClient {

    @PostMapping("/goods/queryGoodsByIds")
    List<GoodsInfoVo> queryGoodsByIds(@RequestParam("goodsIdList") List<String> goodsIdList);

    @PostMapping("/goods/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}

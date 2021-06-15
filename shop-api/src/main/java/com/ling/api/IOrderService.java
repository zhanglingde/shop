package com.ling.api;

import com.ling.entity.Result;
import com.ling.shop.pojo.TradeOrder;

/**
 * 订单接口
 */
public interface IOrderService {

    /**
     * 下单接口
     * @param order
     * @return
     */
    Result confirmOrder(TradeOrder order);

}

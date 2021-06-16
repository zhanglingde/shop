package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TradeGoodsNumberLogKey implements Serializable {
    /**
     * 商品 id
     */
    private Long goodsId;

    /**
     * 订单 id
     */
    private Long orderId;

}
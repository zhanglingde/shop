package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TradeGoodsNumberLog extends TradeGoodsNumberLogKey implements Serializable {
    /**
     * 订单货品数量，需要扣减的库存数量
     */
    private Integer goodsNumber;

    private Date logTime;

}
package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class TradeUserMoneyLogKey implements Serializable {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 余额操作类型，1：付款，2：退款
     */
    private Integer moneyLogType;


}
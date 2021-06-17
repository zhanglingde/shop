package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TradePay implements Serializable {
    /**
     * 支付编号
     */
    private Long payId;
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 是否已支付，0未付款，1订单正在付款，2订单已付款
     */
    private Integer isPaid;

}
package com.ling.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 下单失败，MQ 消息对象
 */
@Data
public class MQEntity {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 优惠券id：下单失败退回优惠券
     */
    private Long couponId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 使用的余额数：下单失败退回用户余额
     */
    private BigDecimal userMoney;
    /**
     * 商品id：下单失败根据消息返回下单库存
     */
    private Long goodsId;
    /**
     * 商品数量
     */
    private Integer goodsNum;


}

package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券信息
 */
@Data
public class TradeCoupon implements Serializable{
    /**
     * 优惠券 id
     */
    private Long couponId;

    /**
     * 优惠券金额
     */
    private BigDecimal couponPrice;

    /**
     * 使用优惠券用户
     */
    private Long userId;

    /**
     * 使用优惠券订单
     */
    private Long orderId;

    /**
     * 是否使用，0：未使用，1：已使用
     */
    private Integer isUsed;
    /**
     * 使用时间
     */
    private Date usedTime;

}
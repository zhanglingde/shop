package com.ling.api;

import com.ling.entity.Result;
import com.ling.shop.pojo.TradeCoupon;

/**
 * 优惠券接口
 */
public interface ICouponService {


    /**
     * 根据ID查询优惠券对象
     * @param coupouId
     * @return
     */
    TradeCoupon findOne(Long coupouId);

    /**
     * 更新优惠券状态
     * @param coupon
     * @return
     */
    Result updateCouponStatus(TradeCoupon coupon);
}

package com.ling.shop.service.impl;

import com.ling.api.ICouponService;
import com.ling.constant.ShopCode;
import com.ling.entity.Result;
import com.ling.exception.CastException;
import com.ling.shop.mapper.TradeCouponMapper;
import com.ling.shop.pojo.TradeCoupon;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Service(interfaceClass = ICouponService.class)
public class CouponServiceImpl implements ICouponService{

    @Autowired
    private TradeCouponMapper couponMapper;

    @Override
    public TradeCoupon findOne(Long coupouId) {
        if(coupouId==null){
            CastException.cast(ShopCode.SHOP_REQUEST_PARAMETER_VALID);
        }

        return couponMapper.selectByPrimaryKey(coupouId);
    }

    @Override
    public Result updateCouponStatus(TradeCoupon coupon) {
        if(coupon==null||coupon.getCouponId()==null){
            CastException.cast(ShopCode.SHOP_REQUEST_PARAMETER_VALID);
        }
        //更新优惠券状态
        couponMapper.updateByPrimaryKey(coupon);
        return new Result(ShopCode.SHOP_SUCCESS.getSuccess(),ShopCode.SHOP_SUCCESS.getMessage());
    }
}

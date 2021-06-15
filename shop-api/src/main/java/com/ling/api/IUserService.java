package com.ling.api;

import com.ling.entity.Result;
import com.ling.shop.pojo.TradeUser;
import com.ling.shop.pojo.TradeUserMoneyLog;

/**
 * 用户服务接口
 */
public interface IUserService {
    /**
     * 根据用户 id 修改用户信息
     */
    TradeUser findOne(Long userId);

    /**
     * 修改用户余额，下单支付，下单失败回退余额
     * @param userMoneyLog
     * @return
     */
    Result updateMoneyPaid(TradeUserMoneyLog userMoneyLog);
}

package com.ling.api;

import com.ling.entity.Result;
import com.ling.shop.pojo.TradeUser;
import com.ling.shop.pojo.TradeUserMoneyLog;

public interface IUserService {
    TradeUser findOne(Long userId);

    Result updateMoneyPaid(TradeUserMoneyLog userMoneyLog);
}

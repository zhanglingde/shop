package com.ling.api;

import com.ling.entity.Result;
import com.ling.shop.pojo.TradeGoods;
import com.ling.shop.pojo.TradeGoodsNumberLog;

/**
 * 商品服务接口
 */
public interface IGoodsService {
    /**
     * 根据ID查询商品对象
     * @param goodsId
     * @return
     */
    TradeGoods findOne(Long goodsId);

    /**
     * 扣减库存
     * @param goodsNumberLog
     * @return
     */
    Result reduceGoodsNum(TradeGoodsNumberLog goodsNumberLog);
}

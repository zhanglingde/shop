package com.ling.shop.service.impl;

import com.ling.api.IGoodsService;
import com.ling.constant.ShopCode;
import com.ling.entity.Result;
import com.ling.exception.CastException;
import com.ling.shop.mapper.TradeGoodsMapper;
import com.ling.shop.mapper.TradeGoodsNumberLogMapper;
import com.ling.shop.pojo.TradeGoods;
import com.ling.shop.pojo.TradeGoodsNumberLog;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Service(interfaceClass = IGoodsService.class)
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private TradeGoodsMapper goodsMapper;

    @Autowired
    private TradeGoodsNumberLogMapper goodsNumberLogMapper;

    @Override
    public TradeGoods findOne(Long goodsId) {
        if (goodsId == null) {
            CastException.cast(ShopCode.SHOP_REQUEST_PARAMETER_VALID);
        }
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    @Override
    public Result reduceGoodsNum(TradeGoodsNumberLog goodsNumberLog) {
        if (goodsNumberLog == null ||
                goodsNumberLog.getGoodsId() == null ||
                goodsNumberLog.getOrderId() == null ||
                goodsNumberLog.getGoodsNumber() == null ||
                goodsNumberLog.getGoodsNumber().intValue() <= 0) {
            CastException.cast(ShopCode.SHOP_REQUEST_PARAMETER_VALID);
        }
        TradeGoods goods = goodsMapper.selectByPrimaryKey(goodsNumberLog.getGoodsId());
        if(goods.getGoodsNumber()<goodsNumberLog.getGoodsNumber()){
            //库存不足
            CastException.cast(ShopCode.SHOP_GOODS_NUM_NOT_ENOUGH);
        }
        //减库存
        goods.setGoodsNumber(goods.getGoodsNumber()-goodsNumberLog.getGoodsNumber());
        goodsMapper.updateByPrimaryKey(goods);


        //记录库存操作日志
        goodsNumberLog.setGoodsNumber(-(goodsNumberLog.getGoodsNumber()));
        goodsNumberLog.setLogTime(new Date());
        goodsNumberLogMapper.insert(goodsNumberLog);

        return new Result(ShopCode.SHOP_SUCCESS.getSuccess(),ShopCode.SHOP_SUCCESS.getMessage());
    }



}

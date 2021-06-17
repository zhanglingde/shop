package com.ling.shop.mq;

import com.alibaba.fastjson.JSON;
import com.ling.constant.ShopCode;
import com.ling.shop.mapper.TradeOrderMapper;
import com.ling.shop.pojo.TradeOrder;
import com.ling.shop.pojo.TradePay;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * 监听订单支付成功修改订单状态
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "payTopic",consumerGroup = "${mq.pay.consumer.group.name}",messageModel = MessageModel.BROADCASTING)
public class PaymentListener implements RocketMQListener<MessageExt>{

    @Autowired
    private TradeOrderMapper orderMapper;

    @Override
    public void onMessage(MessageExt messageExt) {

        log.info("接收到支付成功消息...");

        try {
            //1.解析消息内容
            String body = new String(messageExt.getBody(),"UTF-8");
            TradePay tradePay = JSON.parseObject(body,TradePay.class);
            //2.根据订单ID查询订单对象
            TradeOrder tradeOrder = orderMapper.selectByPrimaryKey(tradePay.getOrderId());
            //3.更改订单支付状态为已支付
            tradeOrder.setPayStatus(ShopCode.SHOP_ORDER_PAY_STATUS_IS_PAY.getCode());
            //4.更新订单数据到数据库
            orderMapper.updateByPrimaryKey(tradeOrder);
            log.info("更改订单支付状态为已支付");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

package com.ling.api;

import com.ling.entity.Result;
import com.ling.shop.pojo.TradePay;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

public interface IPayService {

    /**
     * 创建支付订单
     * @param tradePay
     * @return
     */
    Result createPayment(TradePay tradePay);

    /**
     * 订单支付成功后回调修改订单状态
     * @param tradePay
     * @return
     * @throws InterruptedException
     * @throws RemotingException
     * @throws MQClientException
     * @throws MQBrokerException
     */
    Result callbackPayment(TradePay tradePay) throws InterruptedException, RemotingException, MQClientException, MQBrokerException;

}

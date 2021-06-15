package com.ling.test;

import com.ling.api.IPayService;
import com.ling.constant.ShopCode;
import com.ling.shop.PayServiceApplication;
import com.ling.shop.mapper.TradePayMapper;
import com.ling.shop.pojo.TradePay;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;

@SpringBootTest(classes = PayServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayServiceTest {

    @Autowired
    private IPayService payService;

    @Autowired
    TradePayMapper tradePayMapper;

    @Test
    public void createPayment(){
        long orderId = 351526299216515072L;
        TradePay tradePay = new TradePay();
        tradePay.setOrderId(orderId);
        tradePay.setPayAmount(new BigDecimal(880));
        payService.createPayment(tradePay);
    }

    @Test
    public void callbackPayment() throws InterruptedException, RemotingException, MQClientException, MQBrokerException, IOException {

        long payId = 352516176372441088L;
        long orderId = 351526299216515072L;

        TradePay tradePay = new TradePay();
        tradePay.setPayId(payId);
        tradePay.setOrderId(orderId);
        tradePay.setIsPaid(ShopCode.SHOP_ORDER_PAY_STATUS_IS_PAY.getCode());
        payService.callbackPayment(tradePay);

        System.in.read();

    }

    @Test
    public void test01() {
        TradePay tradePay = tradePayMapper.selectByPrimaryKey(1L);
        System.out.println("tradePay = " + tradePay);

    }

}

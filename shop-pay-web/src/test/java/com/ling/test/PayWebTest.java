package com.ling.test;

import com.ling.constant.ShopCode;
import com.ling.entity.Result;
import com.ling.shop.PayWebApplication;
import com.ling.shop.pojo.TradePay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@SpringBootTest(classes = PayWebApplication.class)
public class PayWebTest {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 创建支付订单
     */
    @Test
    public void createPayment(){
        long orderId = 602904969070383104L;
        TradePay tradePay = new TradePay();
        tradePay.setOrderId(orderId);
        tradePay.setPayAmount(new BigDecimal(900));

        String url = "http://localhost:9090/pay/createPayment";
        Result result = restTemplate.postForEntity(url, tradePay, Result.class).getBody();
        System.out.println(result);
    }

    /**
     * 支付订单付款
     */
    @Test
    public void callBackPayment(){
        long payId = 602913217559273472L;
        long orderId = 602904969070383104L;

        TradePay tradePay = new TradePay();
        tradePay.setPayId(payId);
        tradePay.setOrderId(orderId);
        tradePay.setIsPaid(ShopCode.SHOP_ORDER_PAY_STATUS_IS_PAY.getCode());
        String url = "http://localhost:9090/pay/callBackPayment";
        Result result = restTemplate.postForEntity(url, tradePay, Result.class).getBody();
        System.out.println(result);
    }


}

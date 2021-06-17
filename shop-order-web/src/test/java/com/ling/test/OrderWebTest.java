package com.ling.test;

import com.ling.entity.Result;
import com.ling.shop.OrderWebApplication;
import com.ling.shop.pojo.TradeOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


@SpringBootTest(classes = OrderWebApplication.class)
public class OrderWebTest {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * web 调用接口下单
     */
    @Test
    public void confirmOrder(){
        Long coupouId = 345988230098857984L;
        Long goodsId = 345959443973935104L;
        Long userId = 345963634385633280L;

        TradeOrder order = new TradeOrder();
        order.setGoodsId(goodsId);
        order.setUserId(userId);
        order.setCouponId(coupouId);
        order.setAddress("北京");
        order.setGoodsNumber(1);
        order.setGoodsPrice(new BigDecimal(5000));
        order.setShippingFee(BigDecimal.ZERO);
        order.setOrderAmount(new BigDecimal(5000));
        order.setMoneyPaid(new BigDecimal(200));

        String url = "http://localhost:8084/order/confirm";
        Result result = restTemplate.postForEntity(url, order, Result.class).getBody();

        System.out.println(result);
    }

}

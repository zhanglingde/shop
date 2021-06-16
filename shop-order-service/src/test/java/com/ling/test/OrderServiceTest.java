package com.ling.test;

import com.ling.api.IOrderService;
import com.ling.shop.OrderServiceApplication;
import com.ling.shop.mapper.TradeOrderMapper;
import com.ling.shop.pojo.TradeOrder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;


@SpringBootTest(classes = OrderServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceTest {

    @Autowired
    private IOrderService orderService;

    @Autowired
    TradeOrderMapper tradeOrderMapper;

    /**
     * 测试下单
     * @throws IOException
     */
    @Test
    public void confirmOrder() throws IOException {

        Long coupouId = 345988230098857984L;
        Long goodsId = 345959443973935104L;
        Long userId = 345963634385633280L;

        TradeOrder order = new TradeOrder();
        order.setGoodsId(goodsId);
        order.setUserId(userId);
        order.setCouponId(coupouId);
        order.setAddress("北京");
        order.setConsignee("张三");
        order.setGoodsNumber(1);
        order.setGoodsPrice(new BigDecimal(5000));
        order.setShippingFee(BigDecimal.ZERO);
        order.setOrderAmount(new BigDecimal(5000));
        order.setMoneyPaid(new BigDecimal(100));
        orderService.confirmOrder(order);

        System.in.read();

    }

    @Test
    public void test01() {

        TradeOrder tradeOrder = tradeOrderMapper.selectByPrimaryKey(1L);
        System.out.println(tradeOrder);
    }

}

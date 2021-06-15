package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单商品实体类
 */
@Data
public class TradeGoods implements Serializable {
    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品库存
     */
    private Integer goodsNumber;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;
    /**
     * 商品描述
     */
    private String goodsDesc;
    /**
     * 添加时间
     */
    private Date addTime;


}
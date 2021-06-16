package com.ling.shop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户余额日志记录
 */
@Data
public class TradeUserMoneyLog extends TradeUserMoneyLogKey implements Serializable {
    /**
     * 使用金额数量
     */
    private BigDecimal useMoney;

    private Date createTime;

}
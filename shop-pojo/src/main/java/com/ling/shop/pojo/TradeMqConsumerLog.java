package com.ling.shop.pojo;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * mq 消息消费实体
 */
@Data
public class TradeMqConsumerLog extends TradeMqConsumerLogKey implements Serializable {
    /**
     * 消息id
     */
    private String msgId;
    /**
     * 消息体
     */
    private String msgBody;
    /**
     * 消息的消费状态：0正在处理，1处理成功，2处理失败
     */
    private Integer consumerStatus;
    /**
     * 消费次数
     */
    private Integer consumerTimes;
    /**
     * 消费时间
     */
    private Date consumerTimestamp;
    /**
     * 备注
     */
    private String remark;


}
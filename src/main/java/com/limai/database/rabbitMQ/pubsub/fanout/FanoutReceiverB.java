package com.limai.database.rabbitMQ.pubsub.fanout;

import com.limai.database.common.constant.MQField;
import com.limai.database.rabbitMQ.dto.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 13:34
 * @Desc:
 */
@Component
@Slf4j
public class FanoutReceiverB {
    @RabbitHandler
    @RabbitListener(queues = MQField.MY_FANOUTB_QUEUE)
    public void process(GoodsVo goodsVo){
        log.info("FanoutReceiverB接收到的商品消息是：{}",goodsVo);
    }
}

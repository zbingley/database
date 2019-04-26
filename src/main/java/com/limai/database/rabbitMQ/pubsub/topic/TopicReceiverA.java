package com.limai.database.rabbitMQ.pubsub.topic;

import com.limai.database.common.constant.MQField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 14:39
 * @Desc:
 */
@Component
@Slf4j
public class TopicReceiverA {
    @RabbitHandler
    @RabbitListener(queues = MQField.MY_TOPICA_QUEUE)
    public void process(String msg){
        log.info("TopicReceiverA接收到的消息为:{}",msg);
    }
}

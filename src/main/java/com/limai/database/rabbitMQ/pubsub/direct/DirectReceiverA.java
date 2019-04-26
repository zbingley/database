package com.limai.database.rabbitMQ.pubsub.direct;

import com.limai.database.common.constant.MQField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 14:01
 * @Desc:
 */
@Component
@Slf4j
public class DirectReceiverA {
    @RabbitHandler
    @RabbitListener(queues = MQField.MY_DIRECTA_QUEUE)
    public void process(String msg){
        log.info("DirectReceiverA接收到的字符串消息为：{}",msg);
    }
}

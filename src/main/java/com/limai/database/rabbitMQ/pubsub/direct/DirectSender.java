package com.limai.database.rabbitMQ.pubsub.direct;

import com.limai.database.common.constant.MQField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 13:53
 * @Desc:
 */
@Component
@Slf4j
public class DirectSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public boolean sendDirectA(String msg){
        boolean isOK=true;
        if(StringUtils.isEmpty(msg)){
            log.error("消息为空");
            return isOK;
        }
        rabbitTemplate.convertAndSend(MQField.MY_DIRECT_EXCHANGE,MQField.MY_DIRECT_ROUTINGKEYA,msg);
        isOK=true;
        log.info("DirectSender发送DirectA发送字符串消息结果为：{}",msg);
        return isOK;
    }
    public boolean sendDirectB(String msg){
        boolean isOK=true;
        if(StringUtils.isEmpty(msg)){
            log.error("消息为空");
            return isOK;
        }
        rabbitTemplate.convertAndSend(MQField.MY_DIRECT_EXCHANGE,MQField.MY_DIRECT_ROUTINGKEYB,msg);
        isOK=true;
        log.info("DirectSender发送DirectB发送字符串消息结果为：{}",msg);
        return isOK;
    }
}

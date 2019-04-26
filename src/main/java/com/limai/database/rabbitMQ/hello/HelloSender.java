package com.limai.database.rabbitMQ.hello;

import com.limai.database.common.constant.MQField;
import com.limai.database.rabbitMQ.dto.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 9:22
 * @Desc:
 */
@Slf4j
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public boolean send(String message){
        boolean isOK=false;
        if(StringUtils.isEmpty(message)){
            log.error("消息为空");
            return isOK;
        }
        amqpTemplate.convertAndSend(MQField.HELLO_STRING_QUEUE,message);
        isOK=true;
        log.info("HelloSend发送字符串消息结果：{}",isOK);
        return isOK;
    }
    public boolean send(GoodsVo goodsVo){
        boolean isOK=false;
        if(Objects.isNull(goodsVo)){
            log.error("消息为空");
            return  isOK;
        }
        amqpTemplate.convertAndSend(MQField.HELLO_GOODS_QUEUE,goodsVo);
        isOK=true;
        log.info("HelloSend发送Java对象消息结果：{}",isOK);
        return isOK;
    }
}

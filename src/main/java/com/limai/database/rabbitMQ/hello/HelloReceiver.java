package com.limai.database.rabbitMQ.hello;

import com.limai.database.common.constant.MQField;
import com.limai.database.rabbitMQ.dto.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 9:43
 * @Desc:
 */
@Slf4j
@Component
public class HelloReceiver {
    @RabbitHandler
    @RabbitListener(queues = MQField.HELLO_STRING_QUEUE)
    public void process(String  message){
        try {
            //推迟5秒接收消息，但消息发送端能在发送后立马返回成功结果
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("HelloReceiver接收到的字符串消息是:{}",message);
    }
    @RabbitHandler
    @RabbitListener(queues = MQField.HELLO_GOODS_QUEUE)
    public void process(GoodsVo goodsVo){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("HelloReceiver接收到的Java对象消息是：{}",goodsVo);
    }
}

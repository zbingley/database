package com.limai.database.rabbitMQ.worker;

import com.limai.database.common.constant.MQField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 10:39
 * @Desc:
 */
@Slf4j
@Component
public class WorkerConsumerB {
    private AtomicInteger atomicInteger=new AtomicInteger();
    @RabbitHandler
    @RabbitListener(queues = MQField.MY_WORKER_QUEUE)
    public void process(String message){
        int index = atomicInteger.getAndIncrement();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("WorkerConsumerB接收到的消息：{}",message);
        log.info("WorkerConsumerB自增序列：{}",index);
    }
}

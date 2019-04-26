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
public class WorkerConsumerA {
    private AtomicInteger atomicInteger=new AtomicInteger();
    @RabbitHandler
    @RabbitListener(queues = MQField.MY_WORKER_QUEUE)
    public void process(String message){
        int index = atomicInteger.getAndIncrement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("WorkerConsumerA接收到的消息：{}",message);
        log.info("WorkerConsumerA自增序列：{}",index);
    }
}

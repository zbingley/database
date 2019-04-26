package com.limai.database.rabbitMQ.worker;

import com.limai.database.common.constant.MQField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 10:33
 * @Desc:
 */
@Slf4j
@Component
public class WorkerProducterB {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public boolean send(String message){
        boolean isOK=false;
        if(StringUtils.isEmpty(message)){
            log.error("消息为空");
            return  isOK;
        }
        amqpTemplate.convertAndSend(MQField.MY_WORKER_QUEUE,message);
        isOK=true;
        log.info("WorkerProducterB 发送字符串消息结果：{}",isOK);
        return isOK;
    }
}
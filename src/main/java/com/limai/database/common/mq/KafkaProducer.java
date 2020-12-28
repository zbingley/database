package com.limai.database.common.mq;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/13 15:03]
 */
@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {

        log.info(".......sending.....");

        for (int i = 0; i < 5; i++) {
            JSONObject message = new JSONObject();
            message.put("NO",i);
            message.put("Date",new Date());
            kafkaTemplate.send("test1",message.toJSONString());
        }

    }
    public void send2() {

        log.info(".......sending.2....");

        for (int i = 0; i < 5; i++) {
            JSONObject message = new JSONObject();
            message.put("NO2",i);
            message.put("Date2",new Date());
            kafkaTemplate.send("my-replicated-topic",message.toJSONString());
        }

    }
}

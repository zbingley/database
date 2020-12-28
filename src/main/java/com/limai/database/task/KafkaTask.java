package com.limai.database.task;

import com.limai.database.common.mq.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Zhang bin
 * @version [版本号, 2020/8/19 9:38]
 */
@Component
public class KafkaTask {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Scheduled(fixedRate = 1000, initialDelay = 2000)
    public void testSend() {
        kafkaProducer.send();
    }
}

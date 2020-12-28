package com.limai.database.controller;

import com.limai.database.common.mq.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/13 15:16]
 */
@RestController
@RequestMapping("kafka")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @RequestMapping("/send")
    public void test(){
        log.info("kafka testing .....");
        kafkaProducer.send();
    }

    @RequestMapping("/send2")
    public void test2(){
        log.info("kafka testing ..2...");
        kafkaProducer.send2();
    }

}

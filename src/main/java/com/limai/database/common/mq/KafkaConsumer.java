package com.limai.database.common.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/13 15:12]
 */
@Component
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(id = "stubStatusAll", topics = "#{ 'data_stubStatus_all_biz'}")
//    public void listen(ConsumerRecord<?, ?> record) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            log.info("----------------- record =" + record);
//            log.info("------------------ message =" + message);
//        }
//    }
}

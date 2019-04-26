package com.limai.database.rabbitMQ.pubsub.topic;

import com.limai.database.common.constant.MQField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 14:27
 * @Desc:
 */
@Slf4j
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public boolean sendTopicA(String msg) {
        boolean isOK = false;
        if (StringUtils.isEmpty(msg)) {
            log.error("消息为空");
            return isOK;
        }
        amqpTemplate.convertAndSend(MQField.MY_TOPIC_EXCHANGE, MQField.MY_TOPIC_ROUTINGKEYA, msg);
        isOK = true;
        log.info("TopicSender发送topicA消息的结果为：{}", isOK);
        return isOK;
    }

    public boolean sendTopicB(String msg) {
        boolean isOK = false;
        if (StringUtils.isEmpty(msg)) {
            log.error("消息为空");
            return isOK;
        }
        amqpTemplate.convertAndSend(MQField.MY_TOPIC_EXCHANGE, MQField.MY_TOPIC_ROUTINGKEYB, msg);
        isOK = true;
        log.info("TopicSender发送topicB消息的结果为：{}", isOK);
        return isOK;
    }

    public boolean sendToMatchedTopic() {
        boolean isOK = false;
        String routingKey = "my_topic_routingkeyB.apple.log";//模糊匹配MQField.MY_TOPIC_ROUTINGKEYA
        //String routingKey = "my_topic_routingkeyB.32";//模糊匹配MQField.MY_TOPIC_ROUTINGKEYB
        String matchedKeys = "";
        if (MQField.MY_TOPIC_ROUTINGKEYA.contains(routingKey.split("\\.")[0])) {
            matchedKeys = "TopicReceiverA";
        } else if (MQField.MY_TOPIC_ROUTINGKEYB.contains(routingKey.split("\\.")[0])) {
            matchedKeys = "TopicReceiverB";
        }
        String msg = "message to matched receivers:" + matchedKeys;
        amqpTemplate.convertAndSend(MQField.MY_TOPIC_EXCHANGE, routingKey, msg);
        isOK = true;
        System.out.println(String.format("TopicSender发送字符串消息结果：%s", isOK));
        return isOK;
    }
}

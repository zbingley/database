package com.limai.database.rabbitMQ.controller;

import com.limai.database.rabbitMQ.pubsub.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 14:43
 * @Desc:
 */
@RestController
@RequestMapping(value = "topic",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TopicController {
    @Autowired
    private TopicSender topicSender;
    @RequestMapping(value = "amsg",method = RequestMethod.GET)
    public String sendAMsg(String msg){
        boolean b = topicSender.sendTopicA(msg);
        return String.valueOf(b);
    }
    @RequestMapping(value = "bmsg",method = RequestMethod.GET)
    public String sendBMsg(String msg){
        boolean b = topicSender.sendTopicB(msg);
        return String.valueOf(b);
    }
    @RequestMapping(value = "cmsg",method = RequestMethod.GET)
    public String sendCMsg(){
        boolean b = topicSender.sendToMatchedTopic();
        return String.valueOf(b);
    }
}

package com.limai.database.rabbitMQ.controller;

import com.limai.database.rabbitMQ.pubsub.direct.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 14:07
 * @Desc:
 */
@RestController
@RequestMapping(value = "direct",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DirectController {
    @Autowired
    private DirectSender directSender;
    @RequestMapping(value = "amsg",method = RequestMethod.GET)
    public String sendAMsg(String msg){
        boolean b = directSender.sendDirectA(msg);
        return String.valueOf(b);
    }
    @RequestMapping(value = "bmsg",method = RequestMethod.GET)
    public String sendBMsg(String msg){
        boolean b = directSender.sendDirectB(msg);
        return String.valueOf(b);
    }
}

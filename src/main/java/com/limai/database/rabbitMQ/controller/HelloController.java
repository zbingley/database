package com.limai.database.rabbitMQ.controller;

import com.limai.database.rabbitMQ.dto.GoodsVo;
import com.limai.database.rabbitMQ.hello.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 9:53
 * @Desc:
 */
@RestController
@RequestMapping(value = "hello",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {
    @Autowired
    private HelloSender helloSender;
    @RequestMapping(value = "string",method = RequestMethod.GET)
    public String sendMsg(String msg){
        boolean isOK = helloSender.send(msg);
        return String.valueOf(isOK);
    }
    @RequestMapping(value = "object",method = RequestMethod.POST)
    public String sendMsg(GoodsVo goodsVo){
        boolean isOK = helloSender.send(goodsVo);
        return String.valueOf(isOK);
    }
}

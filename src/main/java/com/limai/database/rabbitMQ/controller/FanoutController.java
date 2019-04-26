package com.limai.database.rabbitMQ.controller;

import com.limai.database.rabbitMQ.dto.GoodsVo;
import com.limai.database.rabbitMQ.pubsub.fanout.FanoutSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 13:38
 * @Desc:
 */
@RestController
@RequestMapping(value = "fanout",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FanoutController {
    @Autowired
    private FanoutSender fanoutSender;
    @RequestMapping(value = "goods",method = RequestMethod.POST)
    public String sendMsg(GoodsVo goodsVo){
        boolean b = fanoutSender.sendGoods(goodsVo);
        return String.valueOf(b);
    }
}

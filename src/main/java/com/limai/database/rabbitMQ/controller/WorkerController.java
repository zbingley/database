package com.limai.database.rabbitMQ.controller;

import com.limai.database.rabbitMQ.worker.WorkerProducterA;
import com.limai.database.rabbitMQ.worker.WorkerProducterB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 10:53
 * @Desc:
 */
@RestController
@RequestMapping(value = "/worker",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WorkerController {
    @Autowired
    private WorkerProducterA workerProducterA;
    @Autowired
    private WorkerProducterB workerProducterB;
    @RequestMapping(value = "/pA",method = RequestMethod.GET)
    public String WokerPASendMsg(String msg){
        boolean send = workerProducterA.send(msg);
        return String.valueOf(send);
    }
    @RequestMapping(value = "/pB",method = RequestMethod.GET)
    public String WokerPBSendMsg(String msg){
        boolean send = workerProducterB.send(msg);
        return String.valueOf(send);
    }
}

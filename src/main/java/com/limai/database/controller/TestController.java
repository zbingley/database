package com.limai.database.controller;

import com.alibaba.fastjson.JSONObject;
import com.limai.database.repository.entity.Student;
import com.limai.database.test.dto.ValidParams;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Stub;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author Zhang bin
 * @version [版本号, 2020/4/10 21:47]
 */
@RestController
public class TestController {

    @RequestMapping("/test1")
    public void test1(String param) {
//        Map map = JSONObject.parseObject(param, Map.class);
        Student student = JSONObject.parseObject(param, Student.class);

        System.out.println(param);
    }

    /**
     * 参数验证注解
     *
     * @param validParams 待验证的参数
     * @return
     */
    @RequestMapping("/test2")
    public void test2(@RequestBody @Valid ValidParams validParams) {
        System.out.println(validParams);

    }
}

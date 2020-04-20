package com.limai.database.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.limai.database.service.NingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Enumeration;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/23 9:24]
 */
@RestController
@RequestMapping("client")
public class NingController {

    @Autowired
    private NingService ningService;

    @RequestMapping("sync")
    public void test() {
        System.out.println("test ning http client");
        ningService.testSync3();
    }

    @RequestMapping("async")
    public void testAsync() {
        System.out.println("test ning http async");
//        ningService.testAsync();
        ningService.testSync1();
    }

    /**
     * Basic Auth鉴权
     */
    @RequestMapping("/test")
    public void test1(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println(request.getAuthType());
        String username = request.getParameter("username");
        String params = request.getParameter("params");
        JSONObject jsonObject = JSON.parseObject(params);
        if (headerNames.hasMoreElements()) {
            String headName = headerNames.nextElement();
            String header = request.getHeader(headName);
            System.out.println(header);
            String substring = header.substring(header.indexOf("Basic") + 6);
            byte[] decode = Base64.getDecoder().decode(substring);
            String usernamePasw = new String(decode);
            String userName = "name";
            String password = "123456";
            String key = "authorization";
            String value = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
            System.out.println("s:" + value);
            System.out.println(usernamePasw);
        }
    }
}

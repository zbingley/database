package com.limai.database.service.impl;

import com.alibaba.fastjson.JSON;
import com.limai.database.service.NingService;
import com.limai.database.service.WxService;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Zhang bin
 * @version [版本号, 2020/5/7 14:25]
 */
@Service
@Slf4j
public class WxServiceImpl implements WxService {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

    @Value("${wx.url}")
    private String requestUrl;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    NingService ningService;

    @Override
    public Map getUserInfo(String code) {
        String url = requestUrl + "sns/jscode2session?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        log.info("requestUrl:{}", url);
        String  result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        Map map = JSON.parseObject(result, Map.class);
        return map;
    }
}

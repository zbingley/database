package com.limai.database.service;

import com.alibaba.fastjson.JSON;
import com.limai.database.dto.User;
import com.limai.database.repository.entity.UserEntity;
import com.ning.http.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/23 9:28]
 */
@Service
@Slf4j
public class NingService {
    /**
     * 构造方式一
     */
    public static AsyncHttpClient client;

    static {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        builder.setConnectTimeout(1500);//与服务端建立连接超时时间，需要考虑网络不稳定的情况
        builder.setReadTimeout(2000);
        builder.setRequestTimeout(2000);//服务端响应结果超时时间
        /*
         * 一般情况，当没有设置requestTimeout，readTimeout起作用；只要设置了requestTimeout，requestTimeout起作用。
         */
        client = new AsyncHttpClient(builder.build());
    }

    /**
     * 构造方式二
     */
    private static AsyncHttpClient httpClient = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().
            setConnectTimeout(2000).setReadTimeout(3000).setRequestTimeout(3000)
            .build());


    public void testSync() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        ListenableFuture<Response> futureResponse = client.prepareGet("http://127.0.0.1:8081/test").execute();
        try {
            Response response = futureResponse.get();
            String responseBody = response.getResponseBody();
            System.out.println(response.getResponseBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * addFormParam相当于form表格提交方式，需要用post请求
     * addQueryParam相当于url拼接参数方式
     */
    public void testSync1() {
        AsyncHttpClient.BoundRequestBuilder requestBuilder = client.preparePost("http://127.0.0.1:8081/test5");
/*        requestBuilder.addFormParam("age", "12");
        requestBuilder.addFormParam("name", "Lucy");*/
//        requestBuilder.addQueryParam("name","Tom");
        Map<String, Object> param = new HashMap<>();
        param.put("name","Tom");
        param.put("bithday",new Date());
        requestBuilder.addQueryParam("param",JSON.toJSONString(param));
        ListenableFuture<Response> futureResponse = requestBuilder.execute();
        try {
            Response response = futureResponse.get();
            String responseBody = response.getResponseBody();
            System.out.println(response.getResponseBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * setBody json格式传参
     */
    public void testSync2() {
        AsyncHttpClient.BoundRequestBuilder requestBuilder = client.preparePost("http://127.0.0.1:8081/test2");
        requestBuilder.addHeader("Content-type", "application/json;charset=utf-8");
        User user = new User();
        user.setAge(10);
        user.setName("A");
        requestBuilder.setBody(JSON.toJSONString(user));
        ListenableFuture<Response> futureResponse = requestBuilder.execute();
        try {
            Response response = futureResponse.get();
            String responseBody = response.getResponseBody();
            System.out.println(response.getResponseBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * setFormParams同addFormParams 表单形式
     */
    public void testSync3() {
        AsyncHttpClient.BoundRequestBuilder requestBuilder = client.preparePost("http://127.0.0.1:8081/test4");
        Param param1 = new Param("name", "2B");
        Param param2 = new Param("age", "21");
        List<Param> params = new ArrayList<>();
        params.add(param1);
        params.add(param2);
        requestBuilder.setFormParams(params);
        ListenableFuture<Response> futureResponse = requestBuilder.execute();
        try {
            Response response = futureResponse.get();
            String responseBody = response.getResponseBody();
            System.out.println(response.getResponseBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void testAsync() {
        AsyncHttpClient.BoundRequestBuilder requestBuilder = client.prepareGet("http://127.0.0.1:8081/test");
        requestBuilder.addHeader("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        requestBuilder.execute(new AsyncCompletionHandler<String>() {
            @Override
            public String onCompleted(Response response) throws Exception {
                System.out.println(response.getResponseBody());
                return response.getResponseBody();
            }

            @Override
            public void onThrowable(Throwable t) {
                System.out.println(t.getMessage());
            }
        });

  /*      ListenableFuture<String> response = client.prepareGet("http://127.0.0.1:8081/test").execute(new AsyncCompletionHandler<String>() {
            @Override
            public String onCompleted(Response response) throws Exception {
                System.out.println("on completed");
                int statusCode = response.getStatusCode();
                String responseBody = response.getResponseBody();
                log.info(statusCode + ":" + response.getResponseBody());
                return responseBody;
            }

            @Override
            public void onThrowable(Throwable t) {
                String message = t.getMessage();
                System.out.println("Throwable message:" + message);
            }
        });*/
    }
}

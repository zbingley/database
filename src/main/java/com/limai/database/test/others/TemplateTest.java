package com.limai.database.test.others;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

/**
 * @description:
 * @author: zhangbin
 * @date: 2019/8/8
 */
public class TemplateTest {
    public static void main(String[] args) {
        String jack = "Jack";
        int i = 10;
        ArrayList<Object> list = new ArrayList<>();
        String substring = jack.substring(1,3);
        System.out.println(substring);
        System.out.println(new BigDecimal(12.52));
        BigDecimalExample bigDecimalExample = new BigDecimalExample();
        bigDecimalExample.setMoney(11.20);
        System.out.println(bigDecimalExample.getMoney());
        System.out.println(new BigDecimal(String.valueOf(bigDecimalExample.getMoney())).subtract(new BigDecimal("10.1")));
String js="{\"cmdId\":15,\"cmdParam\":\"{\\\"severity\\\":5}\",\"stubId\":\"1019461101\"}";
        Map map = JSON.parseObject(js, Map.class);
        System.out.println(map);
    }
}

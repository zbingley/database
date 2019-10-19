package com.limai.database.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangbin
 * @Date: 2019/6/18 10:49
 * @Desc: JSON.toString() 默认不序列化输出null值字段
 */
public class JsonDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", "21");
        map.put("sex", null);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        String s = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        System.out.println(s);
        System.out.println("中".hashCode());
        String createTime = new Timestamp(System.currentTimeMillis()).toString();
        System.out.println(createTime);
        System.out.println("717869088201908191610344001".length());
        System.out.println("FFFFFFFFFFFFFFFFF".length());
    }
}

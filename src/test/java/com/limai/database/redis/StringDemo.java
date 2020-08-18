package com.limai.database.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangbin
 * @Date: 2019/6/3 17:13
 * @Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringDemo {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void getValue(){
        redisTemplate.opsForValue().set("string:key1","val1",100L, TimeUnit.SECONDS);
        redisTemplate.opsForValue().setIfAbsent("string:key","aa");
        redisTemplate.opsForValue().setIfAbsent("string:key1","bb");
    }

    @Test
    public void listDemo(){
//        redisTemplate.opsForList().leftPush("list:key1","val1");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        redisTemplate.opsForList().leftPush("list_key2",list);
    }

    @Test
    public void hashDemo(){
        Map<Object, Object> map = redisTemplate.opsForHash().entries("hash:str");
        redisTemplate.opsForHash().put("hash:str2","key3","value");
        Map<String, Object> hashValue = new HashMap<>();
        hashValue.put("k1","v1");
        hashValue.put("k2","v2");
        redisTemplate.boundHashOps("hash:str2").putAll(hashValue);
        List<Object> keys = Arrays.asList("k1", "k2", "key3");
        List<Object> objects = redisTemplate.boundHashOps("hash:str2").multiGet(keys);
//        Object key = redisTemplate.opsForHash().get("hash:str", "key");
//        System.out.println(key);
        redisTemplate.expire("string_key3",20,TimeUnit.SECONDS);
        BoundValueOperations<String, String> string = redisTemplate.boundValueOps("string");

        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                return null;
            }
        });
    }
}

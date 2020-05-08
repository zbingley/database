package com.limai.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseApplicationTests {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("string_key1","hello world1");
        redisTemplate.opsForList().leftPush("list_key1","value11");
    }

}

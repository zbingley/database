package com.limai.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseApplicationTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void contextLoads() {
//        redisTemplate.opsForValue().set("string_key1","hello world1");
//        redisTemplate.opsForList().leftPush("list_key1","value11");
//        Long incre = redisTemplate.opsForValue().increment("incre", 1);
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        Integer seqNo = (Integer) redisTemplate.opsForValue().get(today);
        if (seqNo == null) {
            seqNo = 0;
            redisTemplate.opsForValue().set(today, 0, 10 + 24 * 60 * 60, TimeUnit.SECONDS);
        } else {
            seqNo = redisTemplate.opsForValue().increment(today, 1).intValue();
        }
        System.out.println(seqNo);
    }

}

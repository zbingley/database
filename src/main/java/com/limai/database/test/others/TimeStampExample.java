package com.limai.database.test.others;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TimeStampExample {
    public static void main(String[] args) {
        DateTimeFormatter da = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        System.out.println(LocalDateTime.now().format(da));


        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",null);
        map.computeIfAbsent("a",key->4);
        System.out.println(map);
    }
}

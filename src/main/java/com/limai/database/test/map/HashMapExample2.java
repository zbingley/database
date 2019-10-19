package com.limai.database.test.map;

import java.util.HashMap;

/**
 * @author: zhang bin
 * @date: 2019/9/4
 */
public class HashMapExample2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            HashMap<String, String> map = new HashMap<>(2);
            map.put("1","1");
            map.put("2","1");
            map.put("3","1");
            map.put("4","1");
            map.put("5","1");
            map.put("6","1");
            map.put("7","1");
            System.out.println(map);
        }
    }

}

package com.limai.database.test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
*  hashMap的遍历map.entrySet()速度快于map.keySet
* */
public class HashMapExample1 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <10000000 ; i++) {
            map.put(i,i);
        }


        /*
        *  遍历方式一：
        * */
        long start = System.currentTimeMillis();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {

        }
        System.out.println(System.currentTimeMillis()-start);

        /*
        *  遍历方式二：
        * */
        long start1 = System.currentTimeMillis();
        Set<Integer> keySet = map.keySet();
        for (Integer key:keySet
             ) {
//            Integer value=map.get(key);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {

        }
        System.out.println(System.currentTimeMillis()-start1);
    }
}

package com.limai.database.test.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*long totalPage = Long.MAX_VALUE;
        for(int i = 0 ;i<totalPage;i++){
            if(i<0){
                System.out.println(i);
            }
        }*/
        /*List<String> list = new ArrayList<String>;
        for (String str:list ) {

        }*/

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        System.out.println(new ArrayList<>().size());
    }
}

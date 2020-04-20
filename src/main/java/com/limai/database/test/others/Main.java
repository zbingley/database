package com.limai.database.test.others;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.*;

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

     /*   Map<String, Integer> items = new HashMap<>();
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

        String string = "asdfdfff";
        String a = string.replace("a", "1");
        System.out.println(string);
        System.out.println(a);*/

        System.out.println(new BigDecimal("50").compareTo(new BigDecimal("50")));
        String string = new BigDecimal("0.5").toString();
        System.out.println(string == null ? StringUtils.EMPTY : string.toString());
        String  str="a";
        String s="str="+Optional.ofNullable(str).orElse("")+"bv";
        String s1 = Optional.ofNullable(str).get();
        System.out.println(s);
        System.out.println(s1);
        System.out.println();
    }
}

package com.limai.database.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        //获取线程安全的list
        List<Integer> list1 = Collections.synchronizedList(list);

        int size = list.size();
        for (int i=0;i<size;i++){
           list.remove(0);
           System.out.println(list);
       }
    }
}

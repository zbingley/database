package com.limai.database.test.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/23 17:11]
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        linkedListAdd();
        arrayListAdd();


    }
    private static void arrayListAdd(){
        long start = System.currentTimeMillis();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(0,i);
        }
        System.out.println("arrayList :"+(System.currentTimeMillis()-start));
    }

    private static void linkedListAdd(){
        long start = System.currentTimeMillis();
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(0,i);
        }
        System.out.println("LinkedList :"+(System.currentTimeMillis()-start));
    }

    private static void test(){
        List<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
    }
}

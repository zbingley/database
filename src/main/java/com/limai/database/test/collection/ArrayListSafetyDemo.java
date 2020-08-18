package com.limai.database.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ArrayList 底层是动态数组，即大小可调，构造时未指定大小默认10，ArrayList是线程不安全的，<br/>
 * 可通过Collections.synchronizedList(list)获取线程安全类，r但使用listIterator()方法时需要手动添加synchronized,<br/>
 * 因为该方法未加synchronized，其它加了同步锁。
 *
 * @author Zhang bin
 * @version [版本号, 2020/6/20 16:32]
 */
public class ArrayListSafetyDemo {

    public static void main(String[] args) {
//        testUnSafety();
//        testSafety();
//        add();
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 假如add方法是线性安全的，累加之和是两项之和，但实际上小于2000，因为add是分两步执行的。
     * 这里需要初始化容量2000，不仍会报越界异常，我觉得是多线程下，未扩容前进行了add操作
     */
    private static void testUnSafety() {
        List<Integer> list = new ArrayList<>(2000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(1);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(1);
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread unsafety size: " + list.size());
    }


    private static void testSafety() {
        List<Integer> list1 = new ArrayList<>(2000);
        List<Integer> list = Collections.synchronizedList(list1);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(1);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(1);
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread safety size: " + list.size());
    }

private static void add(){
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 22; i++) {
        list.add(i);
    }
}

}

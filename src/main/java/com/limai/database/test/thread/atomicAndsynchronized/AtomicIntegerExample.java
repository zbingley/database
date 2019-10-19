package com.limai.database.test.thread.atomicAndsynchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        System.out.println(calculate(1,2));
    }
    public static int calculate(int a,int b){
        AtomicInteger atomicInteger = new AtomicInteger(a);
        return atomicInteger.addAndGet(b);
    }
}

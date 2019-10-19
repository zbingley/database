package com.limai.database.test.thread.atomicAndsynchronized;

import java.util.concurrent.ConcurrentHashMap;

/*
* 两个任务可以同时进入一个对象，只要这个对象的方法是在不同锁上同步的即可
* */
public class SyncObject {
    public static void main(String[] args) {
        DualSync dualSync = new DualSync();
        new Thread(){
            @Override
            public void run() {
                dualSync.f();
            }
        }.start();
        dualSync.get();
    }
}
class DualSync{
    private Object syncObject=new Object();
    public synchronized void f(){
        for (int i=0;i<50;i++){
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void get(){
        synchronized (syncObject) {
            for (int i=0;i<50;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

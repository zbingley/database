package com.limai.database.test.thread.atomicAndsynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
* getValue()必须也是synchronized才能保证原子性，一旦一个线程(task)获得一个对象的同步锁，那么其它线程也不能访问该对象的其它同步方法，非同步方法不受影响。
*
* */
public class AtomicityTest implements Runnable{
    private int i=0;
    public  int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        executorService.execute(atomicityTest);
        while (true){
            int val=atomicityTest.getValue();
            if(val % 2 !=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}

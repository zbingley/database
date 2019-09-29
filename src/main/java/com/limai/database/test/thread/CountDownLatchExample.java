package com.limai.database.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int threadTotal=10;
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<threadTotal;i++){
            executorService.execute(()->{
                System.out.println("Run...,");
                countDownLatch.countDown();//countDownLatch每次调用countDown方法，计数器减1
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}

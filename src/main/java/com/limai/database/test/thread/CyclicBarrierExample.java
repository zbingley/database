package com.limai.database.test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int threadTotal=5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadTotal);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <threadTotal ; i++) {
            executorService.execute(()->{
                System.out.println("before");
                try {
                    cyclicBarrier.await();//cyclicBarrier每次调用await方法，计数器减1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            });
        }
        executorService.shutdown();
    }
}

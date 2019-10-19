package com.limai.database.test.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepTaskDemo implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int timeInSecond = random.nextInt(11);
        try {
            System.out.println(Thread.currentThread()+" will sleep "+timeInSecond+"s");
            TimeUnit.SECONDS.sleep(timeInSecond);
            System.out.println(Thread.currentThread().getName()+" has sleep "+timeInSecond+"s");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new SleepTaskDemo());
        }
        executorService.shutdown();
    }
}

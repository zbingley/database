package com.limai.database.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0;i<5;i++){
            executorService.execute( new LiftOff());
        }
        executorService.shutdown();
    }
}

package com.limai.database.test.thread.sharingResouce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenCheck implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenCheck(IntGenerator intGenerator, int id) {
        this.generator = intGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val=generator.next();
            if(val % 2 !=0){
                System.out.println(val +" not even!");
                generator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp,int count){
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            executorService.execute(new EvenCheck(gp,i));
        }
        executorService.shutdown();
    }
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}

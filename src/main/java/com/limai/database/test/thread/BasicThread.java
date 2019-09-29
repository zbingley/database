package com.limai.database.test.thread;

public class BasicThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LiftOff());
        thread.start();
//        Thread.sleep(0,1);
        System.out.println("Waiting for Liftoff");
    }
}

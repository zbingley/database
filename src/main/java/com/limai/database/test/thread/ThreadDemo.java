package com.limai.database.test.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadExample1 example = new ThreadExample1();
        example.start();
        example.start();
        example.start();
    }

}
 class ThreadExample1 extends Thread{
     @Override
     public void run() {
         System.out.println("start...");
     }
 }

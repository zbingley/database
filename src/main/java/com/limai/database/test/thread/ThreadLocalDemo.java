package com.limai.database.test.thread;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        new Thread(a).start();
        a.setValue();
        Integer integer = a.bThreadLocalVal.get();
        Long aLong = a.aThreadLocalVal.get();

        System.out.println(integer);
        System.out.println(aLong);
    }

   static class A implements Runnable{
    private  ThreadLocal<Long> aThreadLocalVal=new ThreadLocal<>();
    private ThreadLocal<Integer> bThreadLocalVal=new ThreadLocal<>();
        @Override
        public void run() {
        }
        void setValue(){
            System.out.println("A:"+Thread.currentThread().getId());
            aThreadLocalVal.set(Thread.currentThread().getId());
            bThreadLocalVal.set(10);
        }
    }



}

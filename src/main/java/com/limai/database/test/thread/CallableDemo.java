package com.limai.database.test.thread;

import java.util.ArrayList;
import java.util.concurrent.*;
/*
* 创建线程的三种方式：
*  1，继承Thread类重写run方法；
*  2，实现runnable接口；
*  3，实现callable接口，相比runnable可以有返回值；
*
* */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i=0;i<10;i++){
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs :results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            }finally {
                executorService.shutdown();
            }
        }
    }
    static class TaskWithResult implements Callable<String>{
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            return "result of TaskResult "+id;
        }
    }
}

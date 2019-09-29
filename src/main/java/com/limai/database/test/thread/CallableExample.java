package com.limai.database.test.thread;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Demo());
        executorService.execute(futureTask);
        Integer integer = futureTask.get();
        System.out.println(integer);
    }

}
class Demo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}

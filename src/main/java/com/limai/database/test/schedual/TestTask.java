package com.limai.database.test.schedual;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *    springboot 定时任务默认是单线程，当上一个任务未执行完时，下一个任务需等上一个任务执行完后才会开始执行
 *    参考：1、https://mp.weixin.qq.com/s/gmejwIhG70GcO75n0TVSxQ
 *          2、 https://blog.csdn.net/Tabgiver/article/details/86575248
 * @author: zhang bin
 * @date: 2019/9/4
 */
@Slf4j
@Component
//@EnableScheduling
public class TestTask {

//    @Scheduled(cron = "0/5 * * * * ?")
    public void doTask() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"====task1 run");
        Thread.sleep(6000);
        log.info(Thread.currentThread().getName()+"====task1 end");
    }

//    @Scheduled(cron = "0/7 * * * * ?")
    public void doTask2() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"====task2 run");
        Thread.sleep(6000);
        log.info(Thread.currentThread().getName()+"====task2 end");
    }

/*    @Scheduled(cron = "0/5 * * * * ?")
    public void doTask() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"====task run");
        Thread.sleep(6000);
        log.info(Thread.currentThread().getName()+"====task end");
    }*/

      /**
      *  <p>
            fixedDelay设定上一个任务执行完后多久开始执行下一个任务,,
            上一个任务结束到下一个任务开始的时间间隔是5s
       </>
      *
      */
   /* @Scheduled(fixedDelay = 5000)
    public void doTask() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"====task run");
        Thread.sleep(6000);
        log.info(Thread.currentThread().getName()+"====task end");
    }*/

    /**
     *  <p>
          fixedRate设定上一个任务开始时间到下一个任务开始时间的间隔,
           上一个任务开始到下一个任务开始的时间间隔是5s，
          当任务的执行时间大于间隔时间时，下一个任务会在上一个任务执行完后立马执行。
     *  </>
     *
     */
/*      @Scheduled(fixedRate = 5000)
      public void doTask() throws InterruptedException {
          log.info(Thread.currentThread().getName()+"====task run");
          Thread.sleep(2000);
          log.info(Thread.currentThread().getName()+"====task end");
      }*/
}

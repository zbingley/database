package com.limai.database.test.thread.sharingResouce;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {
    private int currentCount=0;
    private Lock lock=new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentCount;
            Thread.yield();
            ++currentCount; 
            return currentCount;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenCheck.test(new MutexEvenGenerator());
    }
}

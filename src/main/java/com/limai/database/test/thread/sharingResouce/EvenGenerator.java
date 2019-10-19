package com.limai.database.test.thread.sharingResouce;

public class EvenGenerator extends  IntGenerator {
    private int currentEvenValue=0;
    @Override
    public   int next() {
//    public  synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); //增加发生的概率
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenCheck.test(new EvenGenerator());
    }
}

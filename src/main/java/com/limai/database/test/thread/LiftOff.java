package com.limai.database.test.thread;

public class LiftOff implements Runnable {
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;
    public LiftOff(){
    }
    public LiftOff(int countDown){
        this.countDown=countDown;
    }
    @Override
    public void run() {
        while (countDown-->0){
            System.out.print(status());
            Thread.yield();
        }
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
    }

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}

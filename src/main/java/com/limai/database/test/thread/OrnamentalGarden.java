package com.limai.database.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        executorService.shutdown();
        if(!executorService.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println("Some tasks were not interrupted!");
        }
        System.out.println("total: "+Entrance.getTotalCount());
        System.out.println("Sum of entrances: "+Entrance.sumEntrance());
    }
}
class Count{
    private int count=0;
    private Random rand=new Random(47);
    public  synchronized int increment(){
        int temp=count;
        if(rand.nextBoolean()){
            Thread.yield();
        }
        return (count=++temp);
    }
    public synchronized int getValue(){
        return count;
    }
}
class Entrance implements Runnable{
    private static Count count=new Count();
    private static List<Entrance> entrances=new ArrayList<Entrance>();
    private int num=0;
    private final int id;
    private static volatile boolean canceled=false;
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }
    public static void cancel(){
        canceled=true;
    }
    @Override
    public void run() {
        while (!canceled){
            synchronized (this) {
                ++num;
            }
            System.out.println(this+" Total: "+count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("stopping "+this);
    }
    public synchronized int getValue(){
        return num;
    }
    public String toString(){
        return "Entrance "+id+": "+getValue();
    }
    public static int getTotalCount(){
        return count.getValue();
    }
    public static int sumEntrance(){
        int sum=0;
        for (Entrance entrance:entrances){
            sum+=entrance.getValue();
        }
        return sum;
    }
}

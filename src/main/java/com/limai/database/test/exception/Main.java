package com.limai.database.test.exception;

public class Main {
    public static void main(String[] args) {
        ThrowDemo throwDemo = new ThrowDemo();
        try {
            int demo = throwDemo. demo(0);
            System.out.println(demo);
        } catch (ArithmeticException ae) {
            System.out.println("ae:"+ae);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

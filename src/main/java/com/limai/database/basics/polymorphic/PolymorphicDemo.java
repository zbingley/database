package com.limai.database.basics.polymorphic;

/**
 * 多态
 *
 * @author Zhang bin
 * @version [版本号, 2020/6/24 14:04]
 */
public class PolymorphicDemo {

    public static void main(String[] args) {
        Father jack = new Children("Jack", 12);
        System.out.println(jack);
    }


}

package com.limai.database.basics.finalKeyword;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/24 14:50]
 */
public class ArrayDemo {
    public static void main(String[] args) {
        final String[] a1={"1","2"};
        final String[] a2={"3","4"};
//        a1=a2;
        a1[1]="44";
        System.out.println(a1[1]);
    }
}

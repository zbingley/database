package com.limai.database.basics.string;

import org.junit.jupiter.api.Test;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/24 15:47]
 */
public class Demo1 {

    public static void main(String[] args) {
        new Demo1().testStringPlus();
    }
    public void testStringPlus(){
        String str="1";
        str+="2";
        str+="3";
        System.out.println(str);
    }
}

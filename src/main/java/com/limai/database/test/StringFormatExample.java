package com.limai.database.test;

import antlr.StringUtils;

import java.util.Random;
import java.util.Set;

/**
 * @author zhang bin
 * @date 2019/11/2
 */
public class StringFormatExample {
    public static void main(String[] args) {
        Random random = new Random();
        /*
         * 不足四位前面补0
         * */
        System.out.println(String.format("%04d", random.nextInt(1000)));

        String abc = String.join(",", "abc");
        //字符串用给的符号拼接
        // StringUtils.join(Set,separator)

        System.out.println(abc);


        System.out.println("https://qrcode.starcharge.com/r#10000001".length());
    }
}

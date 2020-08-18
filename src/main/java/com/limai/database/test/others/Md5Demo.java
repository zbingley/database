package com.limai.database.test.others;

import org.springframework.util.DigestUtils;

/**
 * @author Zhang bin
 * @version [版本号, 2020/7/2 16:28]
 */
public class Md5Demo {
    public static void main(String[] args) {
        String s = DigestUtils.md5DigestAsHex("abc".getBytes());
        System.out.println(s);
    }
}

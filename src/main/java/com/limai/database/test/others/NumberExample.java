package com.limai.database.test.others;

import org.springframework.util.StringUtils;

/**
 * @author: zhang bin
 * @date: 2019/9/7
 */
public class NumberExample {
    private static final String DAIMLER_OFFLINE_KEY_FORMATTER = "daimler:%s:02095";

    public static void main(String[] args) {
        String format = String.format(DAIMLER_OFFLINE_KEY_FORMATTER, 1000101001);
        System.out.println(format);
    }
}

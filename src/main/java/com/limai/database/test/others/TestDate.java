package com.limai.database.test.others;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: zhang bin
 * @date: 2019/9/18
 */
public class TestDate {
    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);

        String format = of.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime of1 = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MAX);

        String format1 = of1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(of);
        System.out.println(format);
        System.out.println(format1);
    }
}

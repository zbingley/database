package com.limai.database.test.others;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
        String  s="";


        String s1="264c444f-9f5b-40db-82e2-f83fef080160,2b443fe7-9834-4e09-87d6-03a5a314e902,637decc2-560b-49ef-a741-0b0423ffbe26,a842cfac-594e-4fb8-9af3-6a9fc20f81db,c0428941-3bd3-4504-8524-4ae4cf326a19,9c9704cb-b39e-406b-8298-3a11801a7e85,8d58dd8c-ed75-4517-b942-718986f1b9d8,a66caac6-f2b6-4554-95d4-be743e92fd0a,77c9f0c4-eb0d-496d-8a34-ff59215c0969,f835000e-653a-4694-b910-239c1127eea7,e4c50982-90ba-40f9-9536-8e6ea0739c34,267ff9e6-4246-446c-bed0-b0e8c59aa5f5,83718add-6767-4800-8433-92cefe6e0a13,eea67f7c-d409-4efa-ba38-e4eccea4f354,e34893c9-5996-43a6-ab2c-2b25d1ac3e98,e2199c51-d13f-4610-82db-ce68ca631fd7,5dcafbbf-311f-4e5d-8be3-83b36b9b6b08,d1dce45e-ad13-4dde-b7d9-7b26f7778eba,250929d4-c3b6-4321-b19d-16019ea94761,ebe76a74-d8d3-4dc9-9e07-9cdf15007ba1,d6d26c3d-c3c0-4a7b-a8c4-4a9502ed4793,f891b6b7-bb99-454f-854d-7c46b776a16a,98dcba10-49ad-4488-9696-15799173086c,836ae06b-a1c9-42dd-8a04-7ca0e99d034b";
        String[] split = s1.split(",");
        for (String s2 : split) {
            s+=s2+"','";
        }
        System.out.println(s);
    }
}

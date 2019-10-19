package com.limai.database.test.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang bin
 * @date 2019/10/11
 */
public class ForeachExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.forEach(x->{
            System.out.println("aa");
        });
        for (Integer integer : list) {
            System.out.println(integer);
        }
        String[] strings = new String[]{};
    }
}

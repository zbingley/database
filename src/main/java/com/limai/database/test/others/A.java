package com.limai.database.test.others;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhang bin
 * @date: 2019/8/22
 */
@Data
public class A {
    private String name;

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String id = map.get("id");
        System.out.println("id==="+id);
    }
}

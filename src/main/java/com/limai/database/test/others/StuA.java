package com.limai.database.test.others;

import lombok.Data;

/**
 * @author: zhang bin
 * @date: 2019/8/22
 */
@Data
public class StuA extends A{
    private String num;

    @Override
    public String toString() {
        return "StuA{" +
                "name="+super.getName() +
                "num='" + num + '\'' +
                '}';
    }
}

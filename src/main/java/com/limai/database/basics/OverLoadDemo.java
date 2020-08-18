package com.limai.database.basics;

import org.apache.kafka.common.protocol.types.Field;

/**
 * 方法名相同参数不同叫重载：overload
 * 子类重新定义父类的方法，是多态的一种表现:override
 *
 * @author Zhang bin
 * @version [版本号, 2020/6/24 13:54]
 */
public class OverLoadDemo {
    public static void main(String[] args) {

    }

    public void load(String name, int age) {

    }


    public void load(String name) {

    }
}

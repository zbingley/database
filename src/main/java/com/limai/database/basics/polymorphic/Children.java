package com.limai.database.basics.polymorphic;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/24 14:06]
 */
public class Children extends Father {
    public Children(String name, int age) {
        super(name, age);
    }


    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

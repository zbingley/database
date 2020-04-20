package com.limai.database.dto;

import lombok.ToString;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/23 9:36]
 */
@ToString
public class User {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

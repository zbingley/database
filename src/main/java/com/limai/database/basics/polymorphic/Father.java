package com.limai.database.basics.polymorphic;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/24 14:05]
 */
public class Father {
    public String name;
    public int age;

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "This is Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

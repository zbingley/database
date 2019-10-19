package com.limai.database.test.map;

import java.util.HashMap;
/*hashMap当存储自定义对象作为key时，
*
* */
public class HashMapExample {
    public static void main(String[] args) {
        Student s1 = new Student(18, "张三");
        Student s2 = new Student(18, "张三");
        Student s3 = new Student(18, "张三");
        HashMap<Student, String> map = new HashMap<>();
        map.put(s1, "1");
        System.out.println(map.get(s2));
        map.put(s3,"3");
        System.out.println(map.get(s1));

    }
}
class Student{
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

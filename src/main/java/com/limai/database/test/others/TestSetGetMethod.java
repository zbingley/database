package com.limai.database.test.others;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/23 15:11]
 */
public class TestSetGetMethod {
    private Integer age;

    public String getAge() {
        return age.toString();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        TestSetGetMethod test = new TestSetGetMethod();
        test.setAge(20);
        String age=test.getAge();
        System.out.println(age);
    }
}

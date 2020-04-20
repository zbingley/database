package com.limai.database.test.others;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang bin
 * @date 2019/11/11
 */
public class BigDecimalExample1 {
    public static void main(String[] args) {
       Map<String, Object> map = new HashMap<>();
       map.put("big",new BigDecimal("12.23"));
        Map<String, Object> map1 = new HashMap<>();
        Object put = map1.put("s", (BigDecimal) map.get("big"));
        System.out.println(map1);
        A a=new A();
        a.setAge(1);
        a.setName("AA");
        Map<String, A> map2 = new HashMap<>();
        Map<String, A> map3 = new HashMap<>();
        map2.put("1",a);
        map3.put("2",a);
        System.out.println(map2);
        a.setName("BB");
        A a1 = map2.get("1");
        a1.setAge(22);
        System.out.println("-----");
        System.out.println(map2);
        System.out.println(map3);

    }
    static class A{
        private String name;
        private int age;

        public A(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public A() {

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
            return "A{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

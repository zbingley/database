package com.limai.database.test.others;

import com.alibaba.fastjson.JSON;

/**
 * @author: zhang bin
 * @date: 2019/8/22
 */
public class TestExtend {
    public static void main(String[] args) {
        StuA stuA = new StuA();
        stuA.setNum("11");
        stuA.setName("stuA");
        A a = new A();
        a.setName("a");
        System.out.println(a instanceof StuA);
        test(stuA);

        System.out.println("============start===========");
        A a1 = new A();
        a1.setName("name");
        String jsonString = JSON.toJSONString(a1);
        StuA stuA1 = JSON.parseObject(jsonString, StuA.class);
        System.out.println(stuA1);
        System.out.println("============end=============");
    }

    public static void test(A a) {
        System.out.println(a);
        if (a instanceof StuA) {
            A b = JSON.parseObject(JSON.toJSONString(a), A.class);
            System.out.println(b);
        }
    }
}

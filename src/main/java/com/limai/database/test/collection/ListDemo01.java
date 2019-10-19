package com.limai.database.test.collection;

import java.util.*;

public class ListDemo01 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new A());
        list.add(new B());
        ArrayList<A> as = new ArrayList<>();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);//Arrays.asList 创建的list底层是数组，大小固定的无法进行add和delete操作
        //integers.add(2);  //  output:UnsupportedOperationException

        List<A> aList = new ArrayList<>();
        A cat = new A(1, "cat");
        aList.add(cat);
        aList.add(new A(2,"monkey"));
        List<A> aList1 = new ArrayList<>();
        aList1.add(cat);
        aList1.add(new A(2,"dog"));
        boolean b = aList.retainAll(aList1);
        System.out.println(aList);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("b");
        treeSet.add("B");
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("j");
        treeSet.add("z");
        System.out.println(treeSet);

        TreeSet<Integer> intSet = new TreeSet<>();
        intSet.add(10);
        intSet.add(1);
        intSet.add(100);
        intSet.add(15);
        intSet.add(26);
        intSet.add(18);
        intSet.add(67);
        System.out.println(intSet);


    }
}
class A{
    private int id;
    private String name;

    public A() {
    }

    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class  B{
    private String name;
}

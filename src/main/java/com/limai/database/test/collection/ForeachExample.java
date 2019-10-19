package com.limai.database.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
*  关于foreach变例集合执行add,remove方法时报ConcurrentModificationException，及解决办法：
*   在执行list的add，remove方法时会执行下面的方法
*   final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
*   在初始化迭代器时 int expectedModCount=modCount,但是进行remove和add操作时modCount++，从而导致modCount != expectedModCount
*   remove解决办法，使用 迭代器的iterator.remove()进行删除操作。
* */
public class ForeachExample {
    public static void main(String[] args) {
        List<Integer > list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
            iterator1.remove();
        }
        System.out.println(list);
     /*   for (Integer s:list ) {
            System.out.println("1111:"+s);
            list.remove(0);
        }*/




        /*for(Iterator iterator=list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }*/
    }
}

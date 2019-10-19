package com.limai.database.test.collection;

import java.util.*;

public class ListDemo02 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Collections.nCopies(4,new User("aa")));
//        System.out.println(users);
        TreeSet<User> users1 = new TreeSet<>(new UserComparator());
        User aa = new User("aa");
        User bb = new User("bb");
        User cc = new User("cc");
        User dd = new User("aa");
        users1.add(aa);
        users1.add(bb);
        users1.add(cc);
        users1.add(dd);
        System.out.println(users1);


        HashSet<User> users2 = new HashSet<>();
        users2.add(aa);
        users2.add(bb);
        users2.add(cc);
        users2.add(dd);

        System.out.println(users2);
    }
}
class UserComparator implements Comparator<User>{

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
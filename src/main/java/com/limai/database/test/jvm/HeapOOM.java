package com.limai.database.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang bin
 * @version [版本号, 2020/8/23 21:39]
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}

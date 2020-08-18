package com.limai.database.basics.finalKeyword;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/24 14:39]
 */
@Getter
@Setter
@ToString
public class FinalStr {
    private String name;

    public static void main(String[] args) {
        final FinalStr finalStr = new FinalStr();
        finalStr.setName("2");
        System.out.println(finalStr.getName());

        final FinalStr finalStr1 = new FinalStr();
//         finalStr1=finalStr; //这行报错了，可见final修饰后不能变的是引用
    }
}

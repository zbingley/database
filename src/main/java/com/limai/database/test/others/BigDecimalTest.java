package com.limai.database.test.others;

import java.math.BigDecimal;
import java.sql.SQLOutput;

/**
 * @description: BigDecimal构造使用String字符串或ValueOf静态方法,构造方法不能传int，double类型值
 * @author: zhangbin
 * @date: 2019/8/12
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("0.05");
        BigDecimal num2 = new BigDecimal(0.05);
        System.out.println(num1.add(new BigDecimal("100")));  // 100.05
        System.out.println(num2.add(new BigDecimal("100")));  // 100.05000000000000000277555756156289135105907917022705078125
        System.out.println(BigDecimal.valueOf(2.3));// 2.3

        System.out.println("::;;"+BigDecimal.valueOf(0.05).add(new BigDecimal("100")));

        System.out.println("=============================================");
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");
        System.out.println(a +"+"+ b +"=" + a.add(b)); //加
        System.out.println(a +"-"+ b +"=" + a.subtract(b)); // 减
        System.out.println(a +"*"+ b +"=" + a.multiply(b)); // 乘
        System.out.println(a +"/"+ b +"=" + a.divide(b)); // 除

        System.out.println("-------------------------------------------");

        /*
        * 使用除法需注意，当除不尽时可能会抛异常，需要补充后面两个参数
        * public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
        * divisor 被除数
        * scale 精确小数点后位数
        * roundingModel  舍入模式：
        *                   ROUND_CEILING    //向正无穷方向舍入
                            ROUND_DOWN    //向零方向舍入
                            ROUND_FLOOR    //向负无穷方向舍入
                            ROUND_HALF_DOWN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5
                            ROUND_HALF_EVEN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP，如果是偶数，使用ROUND_HALF_DOWN
                            ROUND_HALF_UP    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6
                            ROUND_UNNECESSARY    //计算结果是精确的，不需要舍入模式
                            ROUND_UP    //向远离0的方向舍入
        * */
        //        BigDecimal divide = a.divide(BigDecimal.valueOf(1.3));
        BigDecimal divide1 = a.divide(BigDecimal.valueOf(1.3), 2, BigDecimal.ROUND_CEILING);
        System.out.println(divide1);
        BigDecimal c = new BigDecimal("4.3675");
        System.out.println(c.setScale(2,BigDecimal.ROUND_CEILING)); //4.37
        System.out.println(c.setScale(2,BigDecimal.ROUND_DOWN));// 4.36
        System.out.println(c.setScale(2,BigDecimal.ROUND_HALF_DOWN)); //4.37
        System.out.println(c.setScale(3,BigDecimal.ROUND_HALF_DOWN)); //4.367
        System.out.println(c.setScale(3,BigDecimal.ROUND_HALF_UP)); // 4.368
    }
}

package com.blackj.leran.java.statement;

/**
 * Program Name: java-basic
 * <p>
 * Description: java顺序语句
 * <p>
 * Created by Zhang.Haixin on 2018/9/9
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class OrderStatement {

    /**
     * java的执行顺序是从左到右、从上到下依次执行。
     * 其中已；分号结束的地方，表示一条语句的结束。
     * 没有执行代码，只有分号的语句称为空语句。
     */

    public static void main(String [] args) {

        //变量声名语句
        int a = 1, b = 2, c = 3;
        String name = "Jordan";

        //空语句
        ;

        System.out.println("执行顺序=============");
        System.out.println("1.先给a变量赋值为" + a);
        System.out.println("2.给b变量赋值为" + b);
        System.out.println("3.给c变量赋值为" + c);
        System.out.println("4.给name变量赋值为" + name);
        System.out.println("5.执行空语句，代码什么已不做");
        System.out.println("6.最后一次执行打印语句，从上到下依次输出。");
    }
}

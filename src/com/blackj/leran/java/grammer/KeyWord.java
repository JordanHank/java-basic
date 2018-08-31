package com.blackj.leran.java.grammer;

/**
 * Program Name: java-basic
 * <p>
 * Description: java关键字介绍
 * <p>
 * Created by Zhang.Haixin on 2018/8/31
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class KeyWord {

    /**
     * Java关键字是指在Java语言中有特殊含义或者作用的名称，简单点说就是一些单词。
     *  关键字分类：
     *      访问控制符：private protect public
     *      用于定义类、方法、变量的修饰关键字：final abstract static synchronized
     *      用于定义类与类之间的关系：extends implements
     *      用于创建示例、或判断：new this super instanceof
     *      用于异常处理：try catch finally throw throws
     *      用于包：package import
     *      用于定义数据类型：class interface byte short int long float double char boolean void
     *      用于定义数值：true false null
     *      用于控制循环：if else for do while switch case default break continue return
     */

    public static void main(String [] args) {

        System.out.println("java关键字不能当做标识符用来定义类、接口、方法、变量");
        System.out.println("===============================");
        System.out.println("关键字并不需要牢记所有的关键字，只需要在使用的时候能够辨别即可");
        System.out.println("除了关键字以外java还有保留字，例如goto、const等，这些事为了以后扩展使用而保留的特殊字");
        System.out.println("保留字也不能当做标识符用来定义");
    }
}

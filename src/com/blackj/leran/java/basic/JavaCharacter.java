package com.blackj.leran.java.basic;

/**
 * Program Name: java-basic
 * <p>
 * Description: java特性介绍
 * <p>
 * Created by Zhang.Haixin on 2018/8/30
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class JavaCharacter {

    /**
     * Java 语言特点：跨平台性
     *
     * 1.跨平台性指的是通过Java语言编写的应用程序可以在不同的系统是哪个运行，前提是装有Java运行环境。
     *
     * 2.原理，Java运行环境主要是安装Java虚拟机（JVM Java Virtual Machine),Java程序是在虚拟机中运行，
     * 所以不必考虑系统本身
     */

    public static void main(String [] args) {
        System.out.println("Java程序编译执行过程：");
        System.out.println("1.编译.java结尾的java文件生成.class字节码文件");
        System.out.println("2.虚拟机根据系统不同执行不同的解释程序，将字节码解释为机器可读的代码");
        System.out.println("3.执行代码，运行程序。");
    }
}

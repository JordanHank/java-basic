package com.blackj.leran.java.basic;

/**
 * Program Name: java-basic
 * <p>
 * Description: java版本介绍
 * <p>
 * Created by Zhang.Haixin on 2018/8/29
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class JavaVersion {

    /*
    java主要分三个版本：
    1、J2EE(Java 2 Platform Enterprise Edition)企业本
        主要是针对企业级应用开发所发布的版本，是一整套的企业级应用解决方案，
        主要是针对Web应用程序开发，包含技术Servlet Jsp等
    2、J2SE(Java 2 Platform Standard Edition)标准版
        针对桌面应用以及商务应用提供的解决方案，也是java最基础的版本，通过这个
        版本可以开发一些桌面应用
    3.J2ME(Java 2 Platform Micro Edition)缩减版
        这个版本是在J2SE版本基础上进行删减整理而来的一个缩减版，主要是针对
        电子产品以及嵌入式设备提供解决方案。
     */
    public static void main(String [] args) {
        System.out.println("Java version introduce!");
        System.out.println("J2EE J2SE J2ME");
        System.out.println("=================");
        System.out.println("5.0版本过后改名为：JAVAEE JAVESE JAVAME");
    }
}

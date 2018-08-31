package com.blackj.leran.java.grammer;

import java.io.*;

/**
 * Program Name: java-basic
 * <p>
 * Description: Java标识符
 * <p>
 * Created by Zhang.Haixin on 2018/8/31
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class IDentifier {

    /**
     * Java标识符是java中用来标识某个对象的名称，就想叫一个人我们往往会叫他的名字一样，
     * 人的姓名代表了这个人，而标识符代表了java中的某个对象，可以是类、接口、方法、或者变量
     * 在java中要合法的形容某个对象（java中万物皆对象）必须使用标志符
     *
     *      1.标志符由26个英文字母包含大小写（A-Z a-z）、数字（0-9），美元符号（$)以及下划线（_）组成
     *      2.标志符只能以英文字母（A-Z a-z）、美元符号（$)或者下划线（_）开头
     *
     *
     *      注意：关键字不能作为标志符、标志符区分大小写
     */

    public static void main(String [] args) {

        System.out.println("==========请选择你认为对的标志符");
        System.out.println("a:he$89me" + " " + "b:3Emmm" + " " + "c:@mmeE33" + "d:class");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String answer = "";
        System.out.println("请输入答案：");
        try {
            answer = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answer.equals("a") || answer.equals("b")) {
            System.out.println("回答正确！");
        } else if (answer.equals("c")) {
            System.out.println("@符号不能用于标志符");
        } else if (answer.equals("d")) {
            System.out.println("class是关键字");
        } else {
            System.out.println("请输入a-d");
        }
    }
}

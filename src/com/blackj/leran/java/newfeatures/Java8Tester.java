package com.blackj.leran.java.newfeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Program Name: java-basic
 * <p>
 * Description: Java 8 新特性示例
 * <p>
 * Created by Zhang.Haixin on 2019/1/17
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Java8Tester {

    public static void main(String args[]){

        List<String> spots = new ArrayList<String>();
        spots.add("Football");
        spots.add("Basketball");
        spots.add("Tennis ");
        spots.add("Swimming ");
        spots.add("Pingpong");

        List<String> spots_zh = new ArrayList<String>();
        spots_zh.add("足球");
        spots_zh.add("篮球 ");
        spots_zh.add("网球");
        spots_zh.add("游泳");
        spots_zh.add("乒乓球");

        Java8Tester tester = new Java8Tester();
        System.out.println("使用 Java 7 语法: ");
        tester.sortUsingJava7(spots);
        System.out.println(spots);

        System.out.println("使用 Java 8 语法: ");
        tester.sortUsingJava8(spots_zh);
        System.out.println(spots_zh);
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}

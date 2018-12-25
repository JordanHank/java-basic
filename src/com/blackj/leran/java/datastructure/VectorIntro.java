package com.blackj.leran.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Program Name: java-basic
 * <p>
 * Description: java Vactor类的介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/22
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class VectorIntro {

    /**
     * 向量（Vector）类和传统数组非常相似，但是Vector的大小能根据需要动态的变化。
     * Vector类的使用和ArrayList相似，但是Vector是同步访问的，ArrayList不是。涉及同步的时候用Vector类
     */
    public static void main(String [] args) {
        /**
         * Vector类的四种构造函数：
         *      Vector() 创建一个默认的向量，默认大小为10；
         *      Vector(int size) 创建指定大小的向量；
         *      Vector(int size,int incr) 创建指定大小的向量，并且指定向量每次增加的元素数目；
         *      Vector(Collection c) 创建一个包含集合c元素的向量；
         */
        Vector v1 = new Vector();

        //向向量Vector中添加元素
        v1.addElement("123");
        boolean res = v1.add("234"); //返回添加后的结果，true为添加成功，false为添加失败
        System.out.println("向v1中添加234的结果为：" + res);
        System.out.println();

        List<String> collection = new ArrayList<>();
        for (int i = 3; i < 8; i++) {
            String str = i + "" + (i + 1) + "" + (i + 2);
            collection.add(str);
        }
        v1.addAll(collection);

        //获取向量的长度
        int length = v1.capacity();
        System.out.println("默认构造函数的长度为：" + length);
        System.out.println();

        //clone()方法返回向量的一个副本
        Vector v2 = (Vector) v1.clone();

        //获取第一个元素
        String first = v2.firstElement().toString();
        //获取最后一个元素
        String last = v2.lastElement().toString();

        //获取向量中的元素个数
        int size = v2.size();
        for (int i = 0; i < size; i++) {
            //获取指定index的元素
            String str = v2.elementAt(i).toString();

            if (str.equals(first)) {
                System.out.print("(FIRST)" + "");
            }

            //判断向量中是否包含某个元素 包涵返回true 反之返回false
            if (v2.contains("345")) {
                if (i != size -1) {
                    System.out.print(str + " ");
                } else {
                    System.out.print(str);
                }
            }
            if (str.equals(last)) {
                System.out.println("(LAST)");
            }
        }
        System.out.println();

        //查找元素下标Index  如果存在返回下标  否则返回-1
        int exist = v2.indexOf("567");
        System.out.println("567在v2中的下标为: " + exist);
        System.out.println();

        //清空向量的所有元素
        v2.clear();
        //判断向量是否为空
        if (v2.isEmpty()) {
            System.out.println("v2向量是空的");
            System.out.println();
        }

        v1.add("123");
        System.out.println("删除123之前");
        for (Object str : v1) {
            System.out.print(str + " ");
        }
        System.out.println();

        //删除向量中的第一个匹配元素 如果没有则不变
        v1.remove("123");
        System.out.println("删除123之后");
        for (Object str : v1) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println();

        //删除向量的第一个匹配元素和remove()的用法类似不过有返回结果
        boolean re = v1.removeElement("112");
        System.out.println("删除112的结果为：" + re);
        System.out.println();

        System.out.println("删除前v1下标为3的元素为：" + v1.get(3));
        System.out.println();

        //删除指定下标的元素
        v1.removeElementAt(3);
        System.out.println("删除后v1下标为3的元素为：" + v1.get(3));
        System.out.println();

        //返回一个数组，包含此向量中以恰当顺序存放的所有元素。
        Object [] arr = v1.toArray();

        System.out.println("数组的元素有：");
        for (Object obj: arr) {
            System.out.print(obj + " ");
        }
        System.out.println();
        System.out.println();

        //删除所有元素与clear()方法类似
        v1.removeAllElements();
        System.out.println("v1的容量为：" + v1.size());
    }
}

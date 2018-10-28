package com.blackj.leran.java.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Program Name: java-basic
 * <p>
 * Description: java ArrayList类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/28
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ArrayListIntro {

    /**
     * ArrayList 是一个数组队列，和数组不同的是能够动态扩容，也就是我们说的动态数组
     * 继承自AbstractLis，有实现了List接口，可以使用添加、修改、删除遍历等功能
     * 实现了RandomAccess接口，提供随机访问功能，即通过数组下标访问元素
     * 实现了Cloneable接口，覆盖了函数clone()，能被克隆
     * java.io.Serializable接口，支持序列化，能通过序列化去传输
     * 和Vector不同的是ArrayList不是线程安全的，所以涉及多线程的时候不建议使用
     *
     * ArrayList的构造函数：
     *      ArrayList() 默认构造函数，底层数组大小默认为10，空间不如时新的容量=“(原始容量x3)/2 + 1”
     *      ArrayList(int capacity) 指定数组大小的构造函数，空间不足时容量会添加上次容量的一般
     *      ArrayList(Collection<? extends E> collection) 指定Collection的创建
     *
     */
    public static void main(String [] args) {
        //默认方式创建初始化
        ArrayList<Integer> array = new ArrayList<Integer>();
        //添加元素
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        //判断集合中是否包含某个元素
        boolean cont = array.contains("name");
        System.out.println("数组array中包含name: " + cont);
        System.out.println();

        //查找元素的下标
        int index = array.indexOf(7);
        if (index > -1) {
            System.out.println("数组array中包含7");
        } else {
            System.out.println("数组array中不包含7");
        }
        System.out.println();

        //判断数组是否为空
        boolean isEmpty = array.isEmpty();
        System.out.println("数组array是空数组：" + isEmpty);
        System.out.println();

        //获取数组的大小
        int size = array.size();
        if (size > 0) {
            System.out.println("数组array不是空数组");
        } else {
            System.out.println("数组array是空数组");
        }
        System.out.println();

        //移除某个元素
        boolean remove = array.remove(new Integer(5));
        System.out.println("删除5返回：" + remove);
        System.out.println();

        Object rev = array.remove(2);
        System.out.println("删除下标为2的元素：" + rev);
        System.out.println();

        //数组拷贝 浅拷贝（如果数组中包含的对象有其他的对象属性并不会拷贝）
        ArrayList<Integer> cloneArray = (ArrayList<Integer>) array.clone();

        //清空数组
        array.clear();
        System.out.println("数组array的大小为：" + array.size());
        System.out.println();

        // 遍历ArrayList时，使用随机访问(即，通过索引序号访问)效率最高
        System.out.println("随机访问遍历数组cloneArray：");
        for (int i = 0; i < cloneArray.size(); i++) {
            //获取元素
            System.out.print(cloneArray.get(i) + " ");
        }
        System.out.println();

        //迭代器进行遍历 效率最低！
        Iterator iterator = cloneArray.iterator();
        System.out.println("迭代器遍历数组cloneArray中包含元素：");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //转换成对象数组 可能会抛出“java.lang.ClassCastException”异常
        Object [] elements = cloneArray.toArray();
        System.out.println("转换的数组对象包括：");
        for (Object o: elements) {
            System.out.print(o + " ");
        }
        System.out.println();

        //泛型数组转换 不会抛出异常 因为明确转换的类型
        Integer[] integerArray = (Integer[]) cloneArray.toArray(new Integer[0]);
        System.out.println("数组integerArray的大小为：" + integerArray.length);
    }
}

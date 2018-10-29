package com.blackj.leran.java.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Program Name: java-basic
 * <p>
 * Description: java LinkedList介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/29
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class LinkedListIntro {

    /**
     * LinkedList 是一个继承于AbstractSequentialList的双向链表,可以被当作堆栈、队列或双端队列进行操作
     * 实现了List接口，可以使用添加、修改、删除遍历等功能
     * 实现 Deque 接口，即能将LinkedList当作双端队列使用
     * 实现了Cloneable接口，覆盖了函数clone()，能被克隆
     * 实现了java.io.Serializable接口，支持序列化，能通过序列化去传输
     * LinkedList是非线程同步的，所以多线程的场景不建议使用
     *
     * LinkedList的构造函数：
     *      LinkedList() //默认构造函数
     *      LinkedList(Collection<? extends E> collection) //指定Collection的创建
     */
    public static void main(String [] args) {
        /**
         * LinkedList 实际上是通过双向链表去实现的
         * 内部类Node是双向链表节点所对应的数据结构：当前节点所包含的值，上一个节点，下一个节点
         */
        LinkedList linkedList = new LinkedList();

        //添加元素
        for (int i = 0; i < 10; i++) {
            //属于Collection接口的方法 会抛出异常
            linkedList.add(i);
        }

        //向头部添加元素 属于Collection接口的方法 会抛出异常
        linkedList.addFirst(-1);

        //获取第一个元素 属于Collection接口的方法 会抛出异常
        Object first = linkedList.getFirst();
        System.out.println("linkedList数组的第一个元素是："+ first);
        System.out.println();

        //向尾部添加元素 属于Collection接口的方法 会抛出异常
        linkedList.addLast(100);

        //获取最后一个元素 属于Collection接口的方法 会抛出异常
        Object last = linkedList.getLast();
        System.out.println("linkedList数组的最后一个元素是：" + last);
        System.out.println();

        //移除第一个元素 属于Collection接口的方法 会抛出异常
        Object removeF = linkedList.removeFirst();
        System.out.println("linkedList数组移除第一个元素：" + removeF);
        first = linkedList.getFirst();
        System.out.println("linkedList数组移除第一个元素后第一元素为：" + first);
        System.out.println();

        //移除最后一个元素 属于Collection接口的方法 会抛出异常
        Object removeL = linkedList.removeLast();
        System.out.println("linkedList数组移除最后一个元素：" + removeL);
        last = linkedList.getLast();
        System.out.println("linkedList数组移除最后一个元素后最后一元素为：" + last);
        System.out.println();

        //通过迭代器遍历
        System.out.println("通过迭代器遍历:");
        for (Iterator iterator = linkedList.listIterator(); iterator.hasNext();) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //Deque队列时使用的添加方法 返回boolean值不会抛出异常
        boolean offer = linkedList.offer("offer");
        System.out.println("linkedList当做队列时添加元素offer返回：" + offer);
        System.out.println();

        //向队列添加到头部
        boolean offerF = linkedList.offerFirst("first");
        System.out.println("linkedList当做队列时添加头部元素first返回：" + offerF);
        //获取队列头部元素
        first = linkedList.peekFirst();
        System.out.println("peek linkedList第一个元素：" + first);
        System.out.println();

        //向队列尾部添加元素
        boolean offerL = linkedList.offerLast("last");
        System.out.println("linkedList当做队列时添加尾部元素last返回：" + offerL);
        //获取队列尾部元素
        last = linkedList.peekLast();
        System.out.println("peek linkedList最后一个元素：" + last);
        System.out.println();

        //移除头部元素
        Object pollF = linkedList.pollFirst();
        System.out.println("linkedList数组移除第一个元素：" + pollF);
        //获取第一元素
        first = linkedList.element();
        System.out.println("linkedList数组移除第一个元素后第一元素为：" + first);
        System.out.println();

        //移除尾部元素
        Object pollL = linkedList.pollLast();
        System.out.println("linkedList数组移除最后一个元素：" + pollL);
        last = linkedList.getLast();
        System.out.println("linkedList数组移除最后一个元素后最后一元素为：" + last);
        System.out.println();

        //通过for循环遍历
        System.out.println("通过for循环遍历:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.peek() + " ");
        }
        System.out.println();

        //LinkedList可以作为LIFO(后进先出)的栈，作为LIFO的栈时
        //添加到头部
        linkedList.push("push");
        System.out.println("linkedList数组的第一元素为：" + linkedList.peekFirst());
        System.out.println();

        //移除头部元素
        Object pop = linkedList.pop();
        System.out.println("linkedList数组移除第一个元素：" + pop);
        System.out.println();

        //for增强循环
        System.out.println("for增强循环：");
        for (Object o: linkedList) {
            System.out.print(o + " ");
        }
        System.out.println();

        LinkedList copy = (LinkedList) linkedList.clone();

        //通过pollFirst()来遍历LinkedList
        System.out.println("通过pollFirst()来遍历LinkedList：");
        while (copy.pollFirst() != null) {
            System.out.print(copy.pollFirst() + " ");
        }
        System.out.println();

        //通过pollLast()来遍历LinkedList
        System.out.println("通过pollLast()来遍历LinkedList：");
        while (copy.pollLast() != null) {
            System.out.print(copy.pollLast() + " ");
        }
        System.out.println();

        //通过removeFirst()来遍历LinkedList
        System.out.println("通过removeFirst()来遍历LinkedList：");
        try {
            while(copy.removeFirst() != null) {
                System.out.print(copy.pollFirst() + " ");
            }
            System.out.println();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        //通过removeLast()来遍历LinkedList
        System.out.println("通过removeLast()来遍历LinkedList：");
        try {
            while(copy.removeLast() != null) {
                System.out.print(copy.pollFirst() + " ");
            }
            System.out.println();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}

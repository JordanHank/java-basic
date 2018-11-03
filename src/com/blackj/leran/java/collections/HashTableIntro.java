package com.blackj.leran.java.collections;

import java.util.*;

/**
 * Program Name: java-basic
 * <p>
 * Description: java HashTable介绍
 * <p>
 * Created by Zhang.Haixin on 2018/11/2
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class HashTableIntro {

    /**
     * Hashtable 和 HashMap一样也是散列表，用来存储键值对
     * Hashtable 继承自 Dictionary,实现了Map、Cloneable、java.io.Serializable接口
     * 可以进行克隆，支持序列化，能通过序列化去传输
     * Hashtable 是线程同步的，所以它是线程安全的，多线程也可以使用
     * Hashtable 的键key 和 值value都不可以是null,存储的映射也不是有序的
     * HashMap 中两个影响性能的参数是：初始容量initialCapacity 和扩充因子loadFactor
     * 初始容量initialCapacity指定哈希表在创建时的容量
     * 扩充因子loadFactor用于计算哈希表扩充时的条件（哈希表中的条目数超出了扩充因子与当前容量的乘积时）
     * 扩充因子的默认值为0.75
     *
     * Hashtable的构造函数：
     *      public Hashtable() //默认构造函数
     *      public Hashtable(int initialCapacity) //指定初始容量的构造函数
     *      public Hashtable(int initialCapacity, float loadFactor) //指定初始容量和扩充因子的构造函数
     *      public Hashtable(Map<? extends K, ? extends V> t) //指定Map集合的构造函数
     *
     * HashTable的成员变量：
     *      table是一个Entry[]数组类型，而Entry实际上就是一个单向链表用于存储键值对
     *      count是Hashtable的大小，它是Hashtable保存的键值对的数量
     *      threshold扩充阈值，用于判断HashMap是否需要扩充，threshold的值="容量*加载因子"，达到阈值扩充时HashMap容量加倍
     *      loadFactor就是扩充因子，用于计算扩充阈值
     *      modCount用于计算快速失败机制
     *
     */
    public static void main(String [] args) {

        //默认初始化
        Hashtable hashTable = new Hashtable();


        //添加元素
        hashTable.put("name", "Jordan Zhang");
        hashTable.put("gender", "man");
        hashTable.put("hobby", "sports");

        //获取元素
        String name = (String) hashTable.get("name");
        System.out.println("name为：" + name);
        System.out.println();

        //克隆 Hashtable
        Hashtable clone = (Hashtable) hashTable.clone();

        //不允许键或者值为空 会抛出空指针异常  java.lang.NullPointerException
//        hashTable.put(null, null);
//        hashTable.put("key", null);
//        hashTable.put(null, "value");

        //判断是否包含键key
        boolean containsKey = hashTable.containsKey("gender");
        if (containsKey) {
            System.out.println("hashTable中包含键gender");
        } else {
            System.out.println("hashTable中不包含键gender");
        }
        System.out.println();

        //判断是否包含值value
        boolean containsValue = hashTable.containsValue(1243);
        if (containsValue) {
            System.out.println("hashTable中包含值1243");
        } else {
            System.out.println("hashTable中不包含值1243");
        }
        System.out.println();

        //获取Hashtable的大小
        int size = hashTable.size();
        System.out.println("hashTable的容量为：" + size);
        System.out.println();

        //通过键移除键值对
        Object ret = hashTable.remove("name");
        System.out.println("移除hashTable中的键为name的键值对返回：" + ret);
        System.out.println("查询hashTable中键为name返回：" + hashTable.get("name"));
        System.out.println();

        //通过键值对移除
        boolean remove = hashTable.remove("gender", "man");
        System.out.println("移除hashTable中的键值对gender-man返回：" + remove);
        System.out.println();

        //清空Hashtable
        hashTable.clear();

        //判断Hashtable是否为空
        if (hashTable.isEmpty()) {
            System.out.println("hashTable容量为空");
        } else {
            System.out.println("hashTable容量不为空");
        }
        System.out.println();

        System.out.println("Hashtable的遍历方法：");
        //迭代器遍历键值对
        System.out.println("迭代器遍历键值对");
        Iterator iterator = clone.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            // 获取key
            String key = (String) entry.getKey();
            // 获取value
            String value = (String) entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过遍历键遍历
        System.out.println("通过遍历键遍历");
        iterator = clone.keySet().iterator();
        while (iterator.hasNext()) {
            // 获取key
            String key = (String) iterator.next();
            // 获取value
            String value = (String) clone.get(key);
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过遍历值遍历 无法获取键key
        System.out.println("通过遍历值遍历");
        Collection collection = clone.values();
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println();

        //通过Enumeration遍历Hashtable的键
        System.out.println("通过Enumeration遍历Hashtable的键");
        Enumeration keys = clone.keys();
        while(keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = (String) clone.get(key);
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过Enumeration遍历Hashtable的值 无法获取键key
        System.out.println("通过Enumeration遍历Hashtable的值");
        Enumeration values = clone.elements();
        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }
    }
}

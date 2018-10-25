package com.blackj.leran.java.datastructure;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Program Name: java-basic
 * <p>
 * Description: java HashTable类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/25
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class HashTableIntro {

    /**
     * HashTable 是 Dictionary的实现类，又实现了Map 接口，是存储键值对的散列表
     * HashTable 的函数都是同步的，这意味着它是线程安全的。它的key、value都不可以为null
     * HashTable 的四种构造函数：
     *      Hashtable() //默认构造函数
     *
     *      Hashtable(int size) //指定初始大小的构造函数
     *
     *      //扩充因子必须介于0.0和1.0之间，它决定了哈希表在重新调整大小之前的充满程度
     *      Hashtable(int size,float fillRatio) //指定大小和扩充因子
     *
     *      Hashtable(Map m) //以M中元素为初始化元素，容量被设置为M的两倍
     *
     */
    public static void main(String [] args) {

        //创建初始化
        Hashtable<String, String> sports = new Hashtable<>();

        //添加元素
        sports.put("basketball", "favorite");
        sports.put("football", "a little");
        sports.put("swim", "can't");

        Enumeration<String> keys = sports.keys();
        System.out.println("HashTable sports 的 keys: ");
        while (keys.hasMoreElements()) {
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();

        Enumeration<String> values = sports.elements();
        System.out.println("HashTable sports 的 values: ");
        while (values.hasMoreElements()) {
            System.out.print(values.nextElement() + " ");
        }
        System.out.println();

        //遍历HashTable 的三种方法
        System.out.println("第一种==========");
        Iterator<Map.Entry<String, String>> iter = sports.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("entrySet(key: " + key+" | value: " + value + ")");
        }
        System.out.println();

        System.out.println("第二种===========");
        Iterator<String> iterator = sports.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            //获取对应键的值
            String value = sports.get(key);
            System.out.println("key: " + key+" | value: " + value);
        }
        System.out.println();

        System.out.println("第三种==================");
        //由于上面的while (keys.hasMoreElements())已经把所有keys都遍历完了所以必须重新赋值
        keys = sports.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = sports.get(key);
            System.out.println("key: " + key+" | value: " + value);
        }
        System.out.println();

        //判断是否含有指定值得键
        boolean existKey = sports.contains("a little");
        System.out.println("sports中对应值a little得键存在：" + existKey);
        //也可以用下面的方法判断
        existKey = sports.containsValue("can");
        System.out.println("sports中对应值can 得键存在：" + existKey);
        System.out.println();

        //判断是否包含对应的键
        boolean containsKey = sports.containsKey("baseball");
        System.out.println("sports中包含键baseball: " + containsKey);
        System.out.println();

        //获取HashTable的大小
        int size = sports.size();
        System.out.println("sports 的大小为：" + size);
        System.out.println();

        //清空HashTable 使其不包含任何键
        sports.clear();

        //判断HashTable 是否为空
        if (sports.isEmpty()) {
            System.out.println("sports被清空了");
        }
    }
}

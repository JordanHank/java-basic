package com.blackj.leran.java.datastructure;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Program Name: java-basic
 * <p>
 * Description: java Dictionary类的介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/24
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class DictionaryIntro {

    /**
     * Dictionary 类是一个抽象类，用来存储键/值对，作用和Map类相似。
     * Dictionary是一个抽象类,它的所有方法都是抽象的,
     * 这些性质导致它更像一个interface(接口).但是这个类出现时还不存在接口的概念.
     * Dictionary已经过时，新的实现应该实现 Map 接口，而不是扩展此类。
     */
    public static void main(String [] args) {

        //由于Dictionary是一个抽象类 所以使用的时候只能使用它的子类进行创建
        Dictionary<String, String> dictionary = new Hashtable<>();

        //向字典中添加键值对
        Object object = dictionary.put("key", "value");
        System.out.println("put key return: " + object);
        System.out.println();

        for (int i = 1; i < 5; i++) {
            dictionary.put("key" + i, "value" + i);
        }

        //键和值都不能为null 不然抛出NullPointerException
        //dictionary.put(null, null);
        //dictionary.put("null", null);

        //判断字典是否为空
        boolean isEmpty = dictionary.isEmpty();
        System.out.println("dictionary is empty: " + isEmpty);
        System.out.println();

        //获取字典中的条目数
        int size = dictionary.size();
        System.out.println("dictionary size is " + size);
        System.out.println();

        //删除指定键的元素
        Object value = dictionary.remove("key");
        System.out.println("remove key return: " + value);
        System.out.println();

        //返回键的枚举
        Enumeration keys = dictionary.keys();
        //键名枚举不为空
        System.out.println("dictionary keys: ");
        while (keys.hasMoreElements()) {
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();

        //返回值得枚举
        Enumeration values = dictionary.elements();
        System.out.println("dictionary values: ");
        while (values.hasMoreElements()) {
            System.out.print(values.nextElement() + " ");
        }
    }
}

package com.blackj.leran.java.datastructure;

import java.util.BitSet;

/**
 * Program Name: java-basic
 * <p>
 * Description: java BitSet类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/21
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class BitSetIntro {

    /**
     * 一个BitSet类创建一种特殊类型的数组来保存位值。BitSet中数组大小会随需要增加。
     *   BitSet是位操作的对象，值只有0或1即false和true，内部维护了一个long数组，初始只有一个long，
     *   所以BitSet最小的size是64，当随着存储的元素越来越多，BitSet内部会动态扩充，
     *   最终内部是由N个long来存储，这些针对操作都是透明的。
     *   按位操作，每一位的值只有两种 0 或者 1，来表示某个值是否出现过。
     *
     *   BitSet有两个初始化的构造函数，一个带参数，一个不带
     *   带参数的构造函数是指定数组内存大小，由于BitSet底层是long[]数组
     *   所以BitSet最小的size是64，默认就是64位，指定大小后值也是64的整数倍
     *
     *   常见的应用场景是对海量数据进行一些统计工作，比如日志分析、用户数统计等。
     */
    public static void main(String [] args) {

        //把 1 3 5 三个数放bitSet中
        BitSet bitSet=new BitSet();
        bitSet.set(1);
        bitSet.set(3);
        bitSet.set(5);

        //bitSet.length()返回此 BitSet 的"逻辑大小"：BitSet 中最高设置位的索引加 1。
        System.out.println("这时候bitSet的长度是: " + bitSet.length());
        for(int i=0; i<bitSet.length(); i++) {
            if ( i != bitSet.length() -1) {
                System.out.print(bitSet.get(i)+"-");
            } else {
                System.out.print(bitSet.get(i) + "\n");
            }

        }
        System.out.println("**********************");

        //BitSet使用示例
        BitSetIntro.containChars("How do you do? 你好呀");

        System.out.println("===================");
        BitSetIntro.computePrime(100);

    }

    /**
     * 求一个字符串包含的char
     */
    public static void containChars(String str) {
        BitSet used = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            //used.set()将指定索引处的位设置为 true。
            used.set(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = used.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            //used.get() 返回指定索引处的位值。
            if (used.get(i)) {
                sb.append((char) i);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


    /**
     * 求素数 有无限个。一个大于1的自然数
     * 如果除了1和它本身外，不能被其他自然数整除(除0以外）的数称之为素数(质数）
     * 否则称为合数
     */
    public static void computePrime(int size) {
        BitSet sieve = new BitSet(size);
        for (int i = 2; i < size; i++) {
            sieve.set(i);
        }
        int finalBit = (int) Math.sqrt(sieve.size());

        for (int i = 2; i < finalBit; i++) {
            if (sieve.get(i)) {
                for (int j = 2 * i; j < size; j += i) {
                    // sieve.clear() 将索引指定处的位设置为 false。
                    sieve.clear(j);
                }
            }
        }

        int counter = 0;
        for (int i = 1; i < size; i++) {
            if (sieve.get(i)) {
                System.out.printf("%5d", i);
                if (++counter % 15 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

}

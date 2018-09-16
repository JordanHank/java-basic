package com.blackj.leran.java.datetype;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Program Name: java-basic
 * <p>
 * Description: java数组介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/15
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ArrClass {

    /**
     * 数组在java中是一个数据结构，用于存储相同类型的元素
     * 数组时一种特殊的类型，在底层内存可以认为连续的内存空间称为数组，而内存空间存储的数据就是对应的数组元素
     */
    public static void main(String [] args) {

        //数组的定义  数据类型 [] 变量名/数据类型 变量名 [] 两种方式都行，推荐第一种，第二种是C、C++的语言风格
        int [] numbers;
        //数组的创建 因为数组时特殊的引用类型，所以通过new来创建
        //因为数组时连续的内存空间，所以创建时必须确定空间的长度,长度必须是确定的int数据
        int size = 5;
        numbers = new int[size];
        numbers[0] = 3;
        numbers[1] = 34;
        numbers[2] = 67;
        numbers[3] = 12;
        numbers[4] = 54;
        //数组的声名创建可以一起使用
        String [] pets = {"dog", "cat", "horse", "pig"};

        //获取数组的元素需要使用下标index  所以一般配合for循环使用
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("数组numbers的总和是" + sum);


        /**
         *  String [] pets = {"dog", "cat", "horse", "pig"};
         *  在内存中的存储状态：
         *      变量pets记录了四个String类型变量的内存地址
         *      pets[0] 记录了 dog 的内存地址，相应的内存地址存储了String数据dog
         *      pets[1] 记录了 cat 的内存地址，相应的内存地址存储了String数据cat
         *      pets[2] 记录了 horse 的内存地址，相应的内存地址存储了String数据horse
         *      pets[1] 记录了 pig 的内存地址，相应的内存地址存储了String数据pig
         */
        for(String type: pets) {
            System.out.println("这只宠物是" + type);
        }

        //多维数组的定义以及使用,只需要确定第一维的长度即可
        //二位数组可以简单的理解为一维数据对应存储的是另一个数组的地址
        //所以只要确定第一维长度即可，第二维可以在使用的时候在确定长度
        String [][] str = new String[4][];
        str [0] = pets;
        str [1] = new String [1];
        str [1][0] = "hello";
        str [2] = new String [2];
        /**
         * str ->  str[0]  ->  str[0][0] -> "dog"
         *                     str[0][1] -> "cat"
         *                     str[0][2] -> "horse"
         *                     str[0][3] -> "pig"
         *         str[1]  ->  str[1][0] -> "hello"
         *         str[2]  ->  str[2][0]            //定义了内存空间但是没有存储数据
         *                     str[2][1]
         *         str[3]  ->                       //没有定义长度，只知道是一个数组
         *
         */

        //java.util.Arrays类是专门用来操作数组的
        int [] ranNum = {1, 9, 12, 3, 8, 34};

        //排序 默认升序
        Arrays.sort(ranNum);
        System.out.println("ranNum数组排序后为：");
        for(int rag: ranNum) {
            System.out.print(rag + "\t");
        }
        Integer [] new_ranNum = new Integer[ranNum.length];
        for (int i = 0; i < ranNum.length; i++) {
            new_ranNum[i] = ranNum[i];
        }
        Arrays.sort(new_ranNum, new MyComparator());
        System.out.println("new_ranNum数组排序后为：");
        for(int rag: new_ranNum) {
            System.out.print(rag + "\t");
        }

        //二分查找  如果存在返回下标 不存在返回-1
        int exist = Arrays.binarySearch(ranNum, 7);
        if (exist > -1) {
            System.out.println("ranNum数组中存在数字7");
        }
        exist = Arrays.binarySearch(ranNum, 9);
        if (exist > -1) {
            System.out.println("ranNum数组中存在数字9");
        }

        //判断两个数组是否相等 返回boolean值 相等为true 不等为false
        int [] temp = {1, 3, 5, 7};
        System.out.println("数组ranNum和数组temp相等：" + Arrays.equals(ranNum, temp));

        //填充数组
        String [] words = new String[4];
        for(int i = 0; i < words.length; i++) {
            if (null != words[i]) {
                System.out.println("有数据");
            }
        }
        String el = "hello";
        Arrays.fill(words, el);
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            System.out.printf("words数组第%d个元素为%s", i + 1, word);
            System.out.println();
        }

        //数组的拷贝
        int [] t = Arrays.copyOf(temp, temp.length);
        //Arrays.copyOf()的底层实现还是借助的本地方法System.arraycopy()
        int [] x = new int[temp.length];
        System.arraycopy(temp, 0, x, 0, temp.length);
        System.out.println("temp == t " + (temp == t));
        System.out.println("temp equals t " + (Arrays.equals(temp, t)));
        System.out.println("====================================");
        System.out.println("t == x " + (t == x));
        System.out.println("t equals x " + (Arrays.equals(t, x)));

        int [] test = {27, 12, 3, 7, 11, 56, 78, 43};
        SortUtil.fastSort(test, false);
        for(int n: test) {
            System.out.print(n + "\t");
        }
    }
}

class MyComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}


class SortUtil {

    /**
     * 冒泡排序法 依次比较两个相邻数的大小
     * @param original 原始数组
     * @param sort 是否升序 true升序，false降序
     */
    public static void bubbleSort(int [] original, boolean sort) {
        for(int i = 0; i < original.length; i++) {
            for(int j = i + 1; j < original.length; j++) {
                if (sort) {
                    //升序排序
                    if (original[i] > original[j]) {
                        int temp = original[j];
                        original[j] = original[i];
                        original[i] = temp;
                    }
                } else {
                    //降序排序
                    if (original[i] < original[j]) {
                        int temp = original[j];
                        original[j] = original[i];
                        original[i] = temp;
                    }
                }
            }
        }
    }

    /**
     * 选择排序法 取出一个数和剩下的所有数依次进行比较
     * @param original 原始数组
     * @param sort 是否升序 true升序，false降序
     */
    public static void chooseSort(int [] original, boolean sort) {
        for(int i = 0; i < original.length; i++) {
            int index = i;
            for(int j = i + 1; j < original.length; j++) {
                if (sort) {
                    //升序排序
                    if (original[i] < original[j]) {
                        index = j;
                    }
                } else {
                    //降序排序
                    if (original[i] > original[j]) {
                        index = j;
                    }
                }
            }
            int temp = original[index];
            original[i] = original[index];
            original[index] = temp;
        }
    }

    /**
     * 插入排序 默认比较的前面数组时有序的，将比较数插入有序数组依然有序
     * @param original 原始数组
     * @param sort 是否升序 true升序，false降序
     */
    public static void insertSort(int [] original, boolean sort) {
        for(int i = 1; i < original.length; i++) {
            int insert = original[i];
            for(int j = i - 1; j >= 0; j--) {
                if (sort) {
                    if (insert < original[j]) {
                        original[j + 1] = original[j];
                        original[j] = insert;
                    }
                } else {
                    if (insert > original[j]) {
                        original[j + 1] = original[j];
                        original[j] = insert;
                    }
                }
            }
        }
    }

    /**
     * 快速排序法 将一个元素数当做中心点，将数组元素比中心点大的排在右边，比起小的排在左边，递归处理
     * @param original
     * @param sort
     */
    public static void fastSort(int [] original, boolean sort) {
        sortFast(original, 0, original.length - 1, sort);
    }

    //递归处理数组排序
    public static void sortFast(int [] original, int left, int right, boolean sort) {
        if (left < right) {
            int mid = getMiddle(original, left, right, sort);
            if (left < mid) {
                sortFast(original, left, mid - 1, sort);
            }
            if (right > mid) {
                sortFast(original, mid + 1, right, sort);
            }
        }
    }

    //核心交换算法
    private static int getMiddle(int [] original, int left, int right, boolean sort) {
        //将最左边的元素当为中心点元素
        int middle = original[left];
        int temp;
        while (left < right) {
            if (sort) {
                //找出右边比中心点元素小的元素进行交换，记录交换Index
                while (left < right && original[right] >= middle) {
                    right--;
                }
                temp = original[right];
                original[right] = original[left];
                original[left] = temp;
                //找出左边比中心点元素大的元素进行交换，记录交换Index
                while (left < right && original[left] <= middle) {
                    left++;
                }
                temp = original[left];
                original[left] = original[right];
                original[right] =temp;
            } else {
                //找出右边比中心点元素大的元素进行交换，记录交换Index
                while (left < right && original[right] <= middle) {
                    right--;
                }
                temp = original[right];
                original[right] = original[left];
                original[left] = temp;
                //找出左边比中心点元素小的元素进行交换，记录交换Index
                while (left < right && original[left] >= middle) {
                    left++;
                }
                temp = original[left];
                original[left] = original[right];
                original[right] =temp;
            }
        }
        return left;
    }
}
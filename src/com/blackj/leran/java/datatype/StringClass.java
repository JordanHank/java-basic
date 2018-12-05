package com.blackj.leran.java.datatype;

import java.lang.reflect.Field;

/**
 * Program Name: java-basic
 * <p>
 * Description: java String类
 * <p>
 * Created by Zhang.Haixin on 2018/9/24
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class StringClass {

    /**
     * java中String类在开发中是一定会用到的类
     * String类不属于基本类型，是一种特殊的引用类型，则说道引用类型第一点想到的就是初始值默认为null
     */

    public static void main(String [] args) throws Exception {

        /**
         * String 的定义以及使用
         * String类提供了很多种构造方法但是在常见的还是直接使用和通过new 构造使用
         */
        String name = "Jordan";
        String name1 = new String("Jordan");

        /**
         * str1 = "java",jvm首先检查常量池中是否存在java字符串对象，不存在创建字符串，返回创建对象的内存地址
         * str2 = "java",常量池中已经存在java字符串对象，直接返回对象的内存地址
         */
        String str1 = "java";
        String str2 = "java";
        /**
         * str3 = new String("java"),关键字new首先在堆内存创建java字符串对象，检查常量池中
         * 是否已经存在java字符串对象，不存在则先创建然后把常量池中的对象内存地址赋值给对对象的引用，
         * 存在就直接把常量池中的对象内存地址直接给堆内存对象引用，然后返回堆内存对象的内存地址。
         * str3 -> 在常量池中找到了java对象 -> 堆内存保存常量池对象的内存地址 -> 返回堆内存地址
         *
         * str4 = new String("java"),返回新的堆内存地址，只是堆内存中保存的还是常量池中的java对象的内存地址
         */
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println(str1 == str2);		//true
        System.out.println(str1 == str3);		//false
        System.out.println(str3 == str4);		//false
        System.out.println(str3.equals(str4));	//true

        //intern 方法可以返回该字符串在常量池中的对象的引用
        String str5 = str3.intern();
        String str6 = str4.intern();
        System.out.println("str5 == str6: " + (str5 == str6));


        /**
         * String类是不可以改变的，一旦创建初始化成功，就无法修改它的值
         * 为什么说String类不可改变
         * 观察String类的源码发现，String类其实是对数组的封装，它的值其实是保存在final修饰的数组中，
         * 既然是final修饰的那么就表示值不能被修改，当给String变量在次赋值的时候并不是修改了值本身，
         * 而是将新值得对象引用重新赋值给了变量
         */

        name = "changeName"; //这里并不是把Jordan修改了，只是把changeName的对象引用重新赋值给了name变量

        /**
         * String真的不可以改变值吗？
         * 其实可以通过反射来修改String的值，因为保存值得数组变量value只是一个引用，并不是真的值，
         * 所以可以通过反射修改数组value保存的值，达到修改String类的值得目的
         */

        String test = "changeValueTest";

        System.out.println("test的值为： " + test);

        //获取String类声明的value字段
        Field valueField = String.class.getDeclaredField("value");

        //修改value字段的访问权限
        valueField.setAccessible(true);

        //获取test变量对应的value字段引用保存的数组
        char [] val = (char []) valueField.get(test);

        //修改val数组的值，改为newValue
        String t = "newValue";
        char [] n = t.toCharArray();
        for (int i = 0; i < val.length; i++) {
            if (i < n.length) {
                val[i] = n[i];
            } else {
                val[i] = '\n';
            }
        }
        //test变量始终应用的是同一个String对象
        //但是对象已经发生了改变，说明可以通过反射实现修改String的值，但是我们一般不这样放
        System.out.println("test改变后的值为：" + test);

        /**
         * 修改String类的值我们不推荐使用反射去处理，而是使用StringBuffer和StringBuilder去处理
         * StringBuffer和StringBuilder其实底层也是基于数组实现的，
         * 不过保存值得数组并不是final修饰的,所以可以修改其保存的值
         * StringBuffer和StringBuilder最大的区别在于，StringBuffer是线程安全的，因为它有Synchronized修饰的同步方法
         * StringBuilder不是线程安全的，但是速度比StringBuffer快，一般使用StringBuilder除非强调线程安全使用StringBuffer
         */
        StringBuffer sb = new StringBuffer("这是一个String");
        sb.append(",测试");
        System.out.println("sb的值为: " + sb);
        StringBuilder sbu = new StringBuilder("StringBuilder的使用");
        sbu.append(",速度快");
        System.out.println("sbu的值为：" + sbu);

        //String的字符串拼接,一般直接使用+进行拼接
        name1 += "Zhang";
        name.concat("_concat");
        System.out.println("name的值拼接后为：" + name);
        System.out.println("name1的值拼接后为：" + name1);

        //String类的常用方法
        System.out.println("String比较连个值是否相等：" + name.equals(name1));

        System.out.println("忽略大小写比较两个String的值：" + name.equalsIgnoreCase(name1));

        //替换String的值
        System.out.println("ang换为111：" + name.replace("ang", "111"));

        System.out.println("将所有a字母改为大写A：" + name1.replaceAll("a", "A"));

        //截取指定长度的字符串
        System.out.println("将String进行截取：" + "String".substring(0, 3));

        //将字符串根据表达式进行拆分
        String hello = "Hello World !";
        String [] vh = hello.split("\n");
        System.out.println("拆分后：");
        for(String s: vh) {
            System.out.println(s);
        }

        //返回char数组
        char [] arr = "jordan".toCharArray();
        for(char a: arr) {
            System.out.print(a + " ");
        }


    }
}

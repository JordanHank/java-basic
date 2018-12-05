package com.blackj.leran.java.datatype;

/**
 * Program Name: java-basic
 * <p>
 * Description: character类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/14
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class CharacterClass {

    /**
     * Character是基本类型char的包装类型，可以像使用普通类一样使用，能够更好的操作字符
     * Character和char类型的转换也会自动的进行拆箱和装箱
     */
    public static void main(String [] args) {
        //char类型的变量赋值使用单引号赋值单个字符
        char a = 'A';
        //使用Character赋值变量
        Character b = new Character('b');
        Character aPlus = a;
        System.out.println("aPlus装箱后的值为" + aPlus);
        char c = aPlus;
        System.out.println("b拆箱后的值为" + b);

        /**
         * 特殊字符的使用需要借助义移字符，转义字符都是前面带有反斜杠\，这样是告诉编译器这个字符具有特殊含义
         * 常用的转移字符有：\t插入tab键，\b插入后退键，\n换行，\r回车，\'插入单引号，\"插入双引号，\\插入反斜杠
         */
        System.out.println("这里插入Tab键" + "\t" + "\"结束\"");

        //Character类的常用方法，都是静态static修饰的方法，可以类名.方法名的形式调用
        //判断一个字符是不是字母
        char letter = 'A', number = '8';
        if (Character.isLetter(letter)) {
            System.out.println(letter +"是字母");
        } else {
            System.out.println(letter +"不是字母");
        }

        //判断一个字符是不是数字字符
        if (Character.isLetter(number)) {
            System.out.println(number +"是数字字符");
        } else {
            System.out.println(number +"不是数字字符");
        }

        //判断是否是一个空格字符
        String test = "there is whitespace";
        char [] chars = test.toCharArray();
        for(char temp: chars) {
            if (Character.isWhitespace(temp)) {
                System.out.println("这是一个空格字符");
            }
        }

        //判断一个字符是大写字母
        char upper = 'C', lower = 'z';
        if (Character.isUpperCase(upper)) {
            System.out.println(upper + "是一个大写字母字符");
        } else {
            System.out.println(upper + "不是一个大写字母字符");
        }

        //判断一个字符是小写字母
        if (Character.isUpperCase(lower)) {
            System.out.println(lower + "是一个小写字母字符");
        } else {
            System.out.println(lower + "不是一个小写字母字符");
        }

        //将一个字符转换成大写字母
        System.out.println("g转大写后为" + Character.toUpperCase('g'));

        //将一个字符转换成小写字母
        System.out.println("G转小写后为" + Character.toLowerCase('G'));
    }
}

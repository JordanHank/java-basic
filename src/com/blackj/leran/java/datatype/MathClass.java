package com.blackj.leran.java.datatype;

/**
 * Program Name: java-basic
 * <p>
 * Description: java Math类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/12
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class MathClass {

    /**
     * Math类用于执行基本数学运算，包括常见的加减乘除、正弦、余弦、平方等。
     * 由于Math的所有方法都是static 静态的，所以可以直接类名.方法的形式调用，如Math.abs()
     * 下面使用一些常用的函数举例
     */
    public static void main(String [] args) {

        //生成0到1的随机数（常用）
        double randomNum = Math.random();
        if (Math.max(0.5, randomNum) == randomNum) {
            System.out.println("随机数大于二分之一");
        }

        //比较两个相同类型的数的较大值 支持int long float double类型
        //参数不管先后顺序，只返回较大的那个数
        int a = 34, b = 45;
        System.out.println("a和b中的较大值为" + Math.max(a, b));
        System.out.println("a和b中的较大值为" + Math.max(b, a));

        //比较两个相同类型的数的较小值 同max方法类似
        System.out.println("a和b中的较小值为" + Math.min(a, b));

        double x = randomNum * 4;
        System.out.println("x的值为 " + x);
        System.out.println("=================");
        //返回一个数的绝对值 返回值类型包括int long float double
        System.out.println("x的int绝对值为" + (int) Math.abs(x));
        System.out.println("x的long绝对值为" + (long) Math.abs(x));
        System.out.println("x的double绝对值为" + (double) Math.abs(x));
        System.out.println("x的float绝对值为" + (float) Math.abs(x));

        //返回大于等于( >= )给定参数的的最小整数
        System.out.println("x的最小整数位" + Math.ceil(x));

        //返回小于等于（<=）给定参数的最大整数
        System.out.println("x的最大整数位" + Math.floor(x));

        //给定参数四舍五入后的整数
        System.out.println("x四舍五入后的整数为" + Math.round(x));

        //算一个参数的次方 返回double类型
        System.out.println("3的5次方为" + Math.pow(3, 5));

        //求给定参数的算数平方根 返回double类型
        System.out.println("81的算数平方根为" + Math.sqrt(81));
    }
}

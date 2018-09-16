package com.blackj.leran.java.grammer;

/**
 * Program Name: java-basic
 * <p>
 * Description: java函数的定义以及使用
 * <p>
 * Created by Zhang.Haixin on 2018/9/16
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Function {

    /**
     * java函数是为了解决某个问题而封装一部分代码便于重复利用的程序
     * java开发过程中会大量的应用函数，好的函数能够重复利用，提高代码的可阅读性
     */
    public static void main(String [] args) {

        /**
         * 函数的定义格式：
         *      访问权限修饰符 修饰符 返回类型 函数名（参数类型 形参1，
         *          参数类型 形参2，...) {
         *          执行代码
         *          return 返回值;
         *         }
         *     访问权限修饰符：public 默认 protect private
         *     修饰符：final(表示方法不能被覆盖）、static(表示方法为静态共享的方法）
         *     修饰符都是可选的
         *     返回类型，特殊返回类型void，表示没有返回，结束可以不用写return语句
         *     函数名小写字母开头后面的单词首字母大写：如addName
         *     参数列表可以有0或多个参数
         */

        int a = 123, b = 23;
        //静态方法可以直接使用类名.方法名的形式使用
        int max = FunctionDemo.findMax(a, b);
        System.out.println(a + "和" + b + "中较大的是" + max);

        //main方法表示程序的入口，默认写法不允许修改
        //main方法的参数列表args称为命令行参数
        //命令行参数需要编译执行类文件是后面紧跟的参数
        /**
         * 如编译执行Function.java
         * 命令为javac Function.java
         *       java Function this is Function.java
         */
        for(int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }

        //java多态的表现是通过函数的重载、重写来实现的
        //一个类中可以有函数名相同，参数列表不同的函数，称为函数的重载
        //一个类继承某个父类，子类中有和父类中返回值、函数名、参数列表都相同的函数称为函数的重写
        //重写的函数可以访问权限不同，但是只能大不能小

        Child child = new Child();
        Child child1 = new Child("child");
    }

}

class FunctionDemo {

    /**
     * 返回连个整数的较大值
     * @param a 整数变量a
     * @param b 整数变量b
     * @return 返回较大值
     */
    public static int findMax(int a, int b) {
        return a > b? a : b;
    }

    public int overloadFun(String a, int b) {
        return 0;
    }

    public int overloadFun(String a) {
        return 1;
    }

    public int overloadFun(int a, String b) {
        return 2;
    }

    void overreadFun(String a, boolean b) {
        System.out.println("父类方法");
    }
}


class Child extends FunctionDemo {

    private String name;

    //构造函数 没有返回值，和类名相同的方法名，
    // 构造函数可以有多个，如果没有写编译期会自动生成无参构造函数
    public Child() {
        System.out.println("无参构造函数");
    }

    public Child(String name) {
        System.out.println("有参构造函数");
        this.name = name;
    }

    @Override
    public int overloadFun(String a, int b) {
        return 3;
    }

    @Override
    public void overreadFun(String a, boolean b) {
        System.out.println("子类的重写方法");
    }
}
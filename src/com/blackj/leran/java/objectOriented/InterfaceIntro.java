package com.blackj.leran.java.objectOriented;

/**
 * Program Name: java-basic
 * <p>
 * Description: java接口介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/16
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class InterfaceIntro {

    /**
     * java接口是一系列抽象方法的集合，用来描述一些方法的公共性。
     * 接口只描述公共方法的抽象概念，并不需要具体的实现，所以接口中方法都是默认抽象的。
     * 由于接口的抽象性，接口并不能像类一样直接实例化使用，必须通过类实现接口的方法调用。
     * 而类实现接口，必须实现接口的所有抽象方法，与抽象类不同，接口所有方法都是抽象方法，、
     * 而抽象类中可以有普通的非抽象方法，接口中的成员变量只能是 public static final 类型的，
     * 而抽象类中可以有非static final 类型的成员变量，接口可以实现多个，但是类只能继承一个，
     * 接口之间可以多继承，这是由于接口的抽象性，使得接口更加纯粹，运行多继承。
     *
     * 接口特性：
     *     1.接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public abstract，其他修饰符都会报错）。
     *     2.接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，用 private 修饰会报编译错误）。
     *     3.接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。
     *
     * 接口的定义：
     * [可见度] interface 接口名称 [extends 其他的接口名名] {
     *      // 声明变量 public static final
     *      // 抽象方法
     * }
     *
     * 实现接口的注意项：
     *      1.类在实现接口的方法时，不能抛出强制性异常，只能在接口中，或者继承接口的抽象类中抛出该强制性异常。
     *      2.类在重写方法时要保持一致的方法名，并且应该保持相同或者相兼容的返回值类型。
     *      3.如果实现接口的类是抽象类，那么就没必要实现该接口的方法。
     *
     * 接口的实现通过关键字implements完成：
     * class Demo implements interface A, B, C {
     *     //必须实现所以接口的所有抽象方法
     * }
     *
     * 接口之间的多继承：
     * interface A extends interface B, C, D {
     *
     * }
     *
     */
    public static void main(String [] args) {
        InterfaceImplementsClassDemo demo = new InterfaceImplementsClassDemo();
        demo.printDefault();
        System.out.println();

        //向上转型为父类接口
        Master master = demo;
        master.playFootball();
        master.playFootball();
        System.out.println();

        if (master instanceof BasketBall) {
            System.out.println("接口Master是BasketBall的子类");
        }
        System.out.println();
        if (master instanceof Sports) {
            System.out.println("接口Master是Sports的子类");
        }
        System.out.println();

        //调用接口的静态方法
        System.out.println(Master.getName());
    }
}

//标记接口没有包含任何方法的接口 只是用来标记某个公共性
interface Sports {

}

interface BasketBall extends Sports {

    //默认就是public abstract方法
    void playBasketBall();
}

interface Football extends Sports {

    void playFootball();
}

//接口之间的多继承
interface Master extends BasketBall, Football {

    //接口只允许有 public static final 的属性  默认就是
    String NAME = "MASTER";

    /**
     * 在 JDK1.8，允许我们给接口添加两种非抽象的方法实现：
     *      1、默认方法，添加 default 修饰即可；
     *      2、静态方法，使用 static 修饰；
     */

    //默认实现 通过接口实现类的对象来调用。
    default void printDefault() {
        System.out.println("默认实现");
    }

    //这个是静态方法 静态方法只能通过接口名调用
    static String getName(){
        System.out.println("静态方法");
        return NAME;
    }
}

//实现Master的所有接口
class InterfaceImplementsClassDemo implements Master {

    @Override
    public void playBasketBall() {
        System.out.println("我会打篮球");
    }

    @Override
    public void playFootball() {
        System.out.println("我会踢足球");
    }
}
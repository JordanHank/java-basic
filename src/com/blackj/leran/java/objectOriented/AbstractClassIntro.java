package com.blackj.leran.java.objectOriented;

/**
 * Program Name: java-basic
 * <p>
 * Description: java抽象类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/14
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class AbstractClassIntro {

    /**
     * 在面向对象的思想中，所有事物都是对象，而对象是通过的类的实例来描述的。
     * 类是对一类事物的通用属性和公共行为的描述，但是并不是所有的类都可以用来对象实例化，
     * 这种只表示事物的通用性的类叫做抽象类，抽象类用关键字abstract来修饰，不能被实例化
     * 表示方法：
     *      abstract class Demo {
     *
     *      }
     * 当abstract修饰方法的时候，表示这个是抽象方法
     * 抽象方法的表示和普通方法不同，不需要方法体{}，直接以分号结束
     * 表示方法：abstract void test();
     *
     * 抽象类和普通的类没有什么大的分别，也可以有自己的成员变量和方法，方法可以是抽象的也可以不是，不能实例化
     * 有抽象方法的一定是抽象类，但抽象类不一定有抽象方法
     * 构造方法和类方法（static方法）不能被声明为抽象方法
     * 抽象类的子类必须实现父类的所有抽象方法，否则子类也必须声明为抽象类
     * 如果父类的显示构造函数包含参数，子类的构造函数必须显示的调用（通过super调用），不然编译报错
     */
    public static void main(String [] args) {

        //直接实例化会编译不通过，必须实现它的抽象方法
        //AbstractParent parent = new AbstractParent("父类", 35);

        AbstractParent parent = new AbstractParent("父类") {
            @Override
            void sing() {
                System.out.println(this.getName() + "唱张学友的歌");
            }
        };
        parent.sing();
        parent.move();
        System.out.println("=============");

        AbstractParent childA = new Child("子类A", "唱歌");
        childA.sing();
        childA.move();
        //编译报错，静态绑定AbstractParent类中没有dance()方法
        //childA.dance();
        System.out.println("*****************");

        Child childB = new Child("子类B", "唱歌");
        childB.sing();
        childB.move();
        childB.dance();
    }
}

abstract class AbstractParent {

    private String name;

    //抽象方法
    abstract void sing();

    public String getName() {
        return name;
    }

    //普通方法
    public void move() {
        System.out.println(this.name + "向前移动！");
    }

    //构造函数
    public AbstractParent(String name) {
        this.name = name;
    }
}

class Child extends AbstractParent {

    private String hobby;

    @Override
    void sing() {
        System.out.println(this.getName() + "唱周杰伦的歌...");
    }

    public void dance() {
        System.out.println(this.getName() + "跳舞很简单...");
    }

    public Child(String name, String hobby) {
        //如果不写 super(name, age);这句，编译无法通过
        super(name);
        this.hobby = hobby;
    }
}
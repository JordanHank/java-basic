package com.blackj.leran.java.objectOriented;

/**
 * Program Name: java-basic
 * <p>
 * Description: java面向对象继承特征介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/10
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ExtendIntro {

    /**
     * 继承是子类获得父类的基本特征和行为，父类是更抽象的行为、特征的类型，而子类是在
     * 父类的基础上抽象出来的更加具体的类型，父类与子类的关系：is-a
     * 子类继承父类通过关键字extends实现，子类继承父类后可以拥有所有父类的非private的属性和方法
     * 子类比父类更具体的两个方面：子类可以自行扩展自己的属性和方法、子类可以覆盖父类的方法
     * 类的继承只能是单继承，但是可以多重继承：A extends B -> B extends C -> C extends D
     *                                         A extends B,C,D 这种类的继承不允许
     * 接口允许多继承，因为接口没有对应的实现，只有方法的定义所以允许多继承
     *                    interface A extends interface B, C, D
     *
     * 继承会提高代码间的耦合度，降低代码独立性，程序过多的使用继承会导致后期维护困难，所以继承慎用
     *
     * 为了解决java类无法实现多继承的问题，java引入了接口interface的概念
     * 类可以实现多个接口，通过关键字implements: class A implements interface B, C, D
     */
    public static void main(String [] args) {

        ChildA a = new ChildA("ChildA");
        //调用父类的方法
        a.introduce();
        a.run();

        //向上造型，子类可以转型成通用的父类
        /**
         * 子类父类的初始化过程：
         *      初始化子类必先初始化父类
         *      初始化子类必先初始化属性
         *      初始化属性必先初始化静态属性和方法
         */
        Parent b = new ChildB("ChildB");
        b.introduce();
        b.walk();
    }
}

//父类
class Parent implements C, D{
    private String name;

    public Parent(String name) {
        System.out.println("========父类初始化开始");
        this.name = name;
    }

    public void introduce() {
        System.out.println("我的名字是" + this.name);
    }

    @Override
    public void run() {
        System.out.println("跑步前进中==========");
    }

    @Override
    public void walk() {
        System.out.println("慢慢走不着急======");
    }
}

//子类A
class ChildA extends Parent {
    public ChildA(String name) {
        super(name);
    }

    @Override
    public void introduce() {
        System.out.println("子类重写父类方法");
        super.introduce();
    }
}

//子类B
class ChildB extends Parent {
    public ChildB(String name) {
        super(name);
        System.out.println("子类初始化开始=======");
    }
}

interface C {
    void run();
}

interface D {
    void walk();
}
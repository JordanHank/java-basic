package com.blackj.leran.java.objectOriented;

/**
 * Program Name: java-basic
 * <p>
 * Description: java多态性介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/13
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class PolymorphismIntro {

    /**
     * java的多态性是同一行为具有多个不同表现形式的能力
     * java多态是通过重写、重载实现的，方法重载是同一类的多态性表现；方法重写是父子类的多态性表现。
     *
     * 多态性的优点：
     * 可以消除类型间的耦合关系、降低代码耦合度
     * 增加可扩展性，多态的可替换性、可扩展性、接口性提高了代码灵活性，降低维护成本
     *
     * 多态的实现方式：
     * 1.方法的重写重载,重写只会发生在方法不会发生在属性
     * 2.接口的实现
     * 3.抽象类、抽象接口的继承实现
     */
    public static void main(String [] args) {

        /**
         * 向上转型成父类，先检查父类方法表中存不存在实例调用的方法，如果不存在则编译报错
         * 存在则编译通过，执行时通过动态绑定机制查找实例类的方法表，执行对应的方法
         */
        Animals dog = new Dog();
        //dog.swim();  编译不过，因为父类Animals中没有swim()方法
        dog.bark();
        System.out.println(dog.age);
        System.out.println();

        //通过实现同一个接口不同表现的多态性
        Cat cat = new Cat();
        cat.feed();
        System.out.println();

        //方法重载的多态性 重载通过方法列表的不同进行区分
        Dog dog1 = new Dog();
        //属性只会隐藏  调用父类属性需要转型成为父类
        System.out.println(((Animals)dog1).age);
        System.out.println(dog1.age);
        dog1.swim();
        dog1.swim(1111);
    }
}

class Animals {

    public int age;

    void bark() {

    }

    public Animals() {
        this.age = 3;
    }
}

class Dog extends Animals implements Feed{

    public double age;

    public Dog() {
        super();
        this.age = 5;
    }

    @Override
    public void bark() {
        System.out.println("汪汪汪...");
    }

    @Override
    public void feed() {
        System.out.println("给小狗喂狗粮===");
    }

    public void swim() {
        System.out.println("小狗开始游泳...");
    }

    public void swim(long length) {
        System.out.println("小狗游了" + length + "米");
    }
}

class Cat extends Animals implements Feed{

    @Override
    public void bark() {
        System.out.println("喵喵喵...");
    }

    @Override
    public void feed() {
        System.out.println("给小猫喂猫粮=====");
    }
}

abstract interface Feed {

    public void feed();
}
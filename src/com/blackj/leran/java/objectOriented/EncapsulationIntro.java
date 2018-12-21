package com.blackj.leran.java.objectOriented;

/**
 * Program Name: java-basic
 * <p>
 * Description: java封装介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/15
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class EncapsulationIntro {

    /**
     * java封装：在面向对象编程思想中，封装指的是一种将抽象性函式接口的实现细节部份包装、隐藏起来的方法。
     * 封装可以认为是一种防护屏障，防止该类的代码和数据被外部类定义的代码随机访问。
     * 对类进行封装后，只能通过严格的接口访问私有数据，这样提高了代码的安全性，同时降低了代码耦合
     *
     * 封装的方法：
     *  1.降低成员属性的可见性（一般是设置为private)
     *  2.设置公共方法访问修改后的私有属性（设置set/get方法）
     *
     * 封装的优点：
     *  1. 良好的封装能够减少耦合。
     *  2. 类内部的结构可以自由修改。
     *  3. 可以对成员变量进行更精确的控制。
     *  4. 隐藏信息，实现细节。
     */
    public static void main(String [] args) {

        Student a = new Student("132444313123", "张三", 21);
        System.out.println(a);
        System.out.println("=======");

        //通过set方法修改私有属性name
        a.setName("李四");
        //通过get方法获取私有属性name
        String name = a.getName();
        System.out.println(name);
    }
}


class Student {

    //私有属性限制访问
    private String id;

    private String name;

    private int age;

    //构造函数
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //通过set/get方法访问私有属性
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "学生：" + this.name + ", " + this.age + "岁， " + "学号为： " + this.id;
    }
}
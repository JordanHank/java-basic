# 对象

在Java 中任何事物都可以抽象成类的概念，类是一类事物的统称描述。
例如：生活中存在很多车，小汽车、大卡车、火车...这些我们都可以抽象的统称为车；这里车也就是Java 中类的概念。

## 类的定义

Java 类的定义一般包含以下几个部分：

+ 属性（包括静态属性和非静态属性）

+ 方法（包括静态方法和非静态方法）

+ 构造函数（包括无参构造函数和有参构造函数），如果没有显示的声名构造函数，创建对象时默认使用无参构造函数。

注意：
+ [关键字](/grammer/keyword) class 后面的名称就是类名，一个Java 文件只允许有一个public 的类并且public类名必须和文件名相同，不然无法编译通过。
+ 类文件的第一行用来声名包，例如：package com.blackj.leran.java.grammer;
+ 在包后面是引用语句，例如：import java.util*;
+ 之后才是类定义,顺序不能错不然那无法通过编译。

## 示例
``` java
package com.blackj.leran.java.grammer;

/**
 * Program Name: java-basic
 * <p>
 * Description: java类的声明定义以及对象的关系
 * <p>
 * Created by Zhang.Haixin on 2018/9/3
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ObjDeclare {

    //一个java文件只能有一个main方法，并且写法是固定的，main方法是类编译执行的入口
    public static void main(String [] args) {

        /**
         * 对象是类的实例
         * 猫和狗都是动物类，但确是不同的对象
         */
        Animal dog = new Animal();

        Animal cat = new Animal("cat", "female");

        dog.say("狗叫=======汪汪汪");
        cat.say("猫叫=======喵喵喵");

        //静态方法可以使用类名.方法名的形式使用
        if ( Animal.canMove()) {
            System.out.println("动物天生都会跑");
        }
    }
}


class Animal {

    //静态属性
    private static String gender;

    //属性
    private String name;

    //无参构造函数
    public Animal() {
        System.out.println("无参构造函数");
        this.gender = "male";
        System.out.println("gender: " + this.gender);
    }

    //含参构造函数
    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;
        System.out.println("========含参构造函数");
    }

    //静态方法
    public static boolean canMove() {
        System.out.println("静态方法");
        return true;
    }

    //非静态方法
    public void say(String something) {
        System.out.println(something);
        System.out.println("=======非静态方法");
    }
}
```
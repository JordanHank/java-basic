# 抽象类

Java 是一门面向对象编程的编程语言，在面向对象的思想中，所有事物都是对象，而对象是通过的类的实例来描述的。
类是对一类事物的通用属性和公共行为的描述，但是并不是所有的类都可以用来对象实例化，这种只表示事物的通用性的类叫做抽象类。

## 语法

抽象类的定义与普通类的定义类似，区别在于需要用关键字`abstract`来修饰，不能被实例化。
``` java
abstract class 类名 {

}
``` 

当`abstract`修饰方法的时候，表示这个是抽象方法，抽象方法的表示和普通方法不同，抽象方法没有方法体，只有方法声名，所以不需要方法体{}，直接以分号结束。
``` java
//普通方法
abstract void test() {
    //方法体
    ...
}

//抽象方法
abstract void test();
``` 

抽象类和普通的类没有什么大的分别，也可以有自己的成员变量和方法，方法可以是抽象的也可以不是，但是不能实例化。

``` java
abstract class AbstractDemo {

    private String name;

    //抽象方法
    abstract void doSomething();

    //普通方法
    public void printHello() {
        System.out.println("Hello " + this.name);
    }

}
```
!>**注意：** 有抽象方法的一定是抽象类，但是抽象类不一定有抽象方法。

## 继承

抽象类也可以被继承，但是有一点需要注意，就是子类继承抽象类时如果没有实现抽象类的所有抽象方法，那么子类也必须声明成抽象类。抽象类无法实例化使用，但是可以使用抽象类的子类。

``` java
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

    //显式的声名含参构造函数
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
        //主动调用父类构造函数
        super(name);
        this.hobby = hobby;
    }
}
```
!> **注意：** 如果父类显示的声名了含参构造函数而没有无参构造函数，则子类构造函数不行显示的调用`super(对应的参数列表)`，不然无法编译通过。

## 总结

+ 抽象类一定不能实例化声名使用，这样会无法通过编译。

+ 有抽象方法的一定是抽象类，但是抽象类不一定有抽象方法。

+ 声名为抽象方法的一定不能有方法体，不然会编译报错。

+ 构造方法和类方法（static方法）不能被声明为抽象方法。

+ 抽象类的子类必须实现父类的所有抽象方法，否则子类也必须声明为抽象类。

+ 如果父类的显示构造函数包含参数，子类的构造函数必须显示的调用（通过super调用），不然编译报错。

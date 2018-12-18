# 继承

继承是子类获得父类的基本特征和行为，父类是更抽象的行为、特征的类型，而子类是在父类的基础上抽象出来的更加具体的类型，父类与子类的关系：`is-a`。
子类继承父类通过关键字`extends`实现，子类继承父类后可以拥有所有父类的非`private`的属性和方法。

## 语法
``` java
//子类通过extends关键字继承父类
class 子类 extends 父类 {

}

class 父类 {

}
```

子类比父类更具体的两个方面：子类可以自行扩展自己的属性和方法、子类可以覆盖父类的方法。
``` java
class Child extends Parent {

    //子类自定义扩展属性
    public String personality;

    public Child(String name, String personality) {
        super(name);
        this.personality = personality;
    }

    @Override
    public void walk() {
        System.out.println("子类重写父类行走方法！");
    }
}

class Parent {

    public String name;

    public Parent(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println("父类行走方法！");
    }
}
```

Java 中的向上造型指的是子类可以转型成通用的父类使用，但是只能使用父类中继承的公共属性或者函数，不能使用扩展属性或者函数。
``` java
Parent child = new Child("Child", "Kind");
System.out.println(child.name);
/**
*   向上造型后无法访问子类扩展属性
*   System.out.println(child.personality);
*/
child.walk();
```

#### 子类初始化

子类父类的初始化过程主要记住以下三点：
 
+ 初始化子类必先初始化父类。

+ 初始化子类必先初始化属性。

+ 初始化属性必先初始化静态属性和方法。


## 继承的使用

继承的使用分为类的继承和接口的继承，不同的继承规则也不同。

#### 类的继承

类的继承通过`extends`关键字来实现，主要是以下两点注意事项：
+ 类的继承只能是单继承，`A extends B,C,D` 这种类的继承不允许。

+ 类的继承可以多重继承，比如：`A extends B -> B extends C -> C extends D`。通过多重继承子类可以获得多个公共属性和公共方法。

``` java
class GrandParent{
    //父类的父类
}

class Parent extends GrandParent {
    //父类
}

class Child extends Parent {
    //子类
}
```

##### super 与 this 关键字

为了在使用时区分子类和父类之间的关系，Java 使用了`super`和`this`关键字：
+ super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前对象的父类；也可以使用`super()`显式调用父类构造函数。

    + 子类是不继承父类的构造造函数的，它只是调用（隐式或显式）。
    
    + 如果父类的构造器带有参数，则必须在子类的构造器中显式地通过 super 关键字调用父类的构造器并配以适当的参数列表。
    
    + 如果父类构造器没有参数，则在子类的构造器中不需要使用 super 关键字调用父类构造器，系统会自动调用父类的无参构造器。

+ this关键字：指向自己的引用，调用自己的属性或者函数。

``` java
public class test {

    public static void main(String [] args) {
        Child child = new Child("Jordan", "sports");
        child.printNameAndHobby();
    }

}

//父类
class Parent{
    //父类私有属性name
    public String name;

    public Parent(String name) {
        this.name = name;
    }
}

//子类
class Child extends Parent {

    //子类扩展属性age
    private String hobby;

    public Child(String name, String hobby) {
        //通过super关键字调用父类构造函数
        super(name);
        //this关键字指向自己的引用
        this.hobby = hobby;
    }

    public void printNameAndHobby() {
        System.out.println(super.name + ":" + this.hobby);
    }
}
```

**结果：** ![extends示例结果](../_media/objectoriented/extendsResult.png)


为了解决java类无法实现多继承的问题，java引入了接口[interface接口](/objectoriented/interface)的概念，类可以通过关键字`implements`实现多个接口:
``` java
class 类 implements 接口1, 接口2, 接口3,... {

}

interface 接口1 {

}

interface 接口2 {

}

interface 接口3 {

}
...
```

**示例：**
``` java
class Demo implements A, B{

    @Override
    public void run() {
        System.out.println("跑步前进中==========");
    }

    @Override
    public void walk() {
        System.out.println("慢慢走不着急======");
    }
}


interface A {
    void run();
}

interface B {
    void walk();
}
```

#### 接口的继承

接口是事物行为的更抽象表达，所以它只有函数的声名，而没有具体的函数实现，也正是因为这点，接口之间允许使用`extends`关键字进行多继承，因为接口继承了多个接口之后还是接口本身，并不会影响函数的实现。
``` java
interface 接口 extends 接口1, 接口2, 接口3,... {

}

interface 接口1 {

}

interface 接口2 {

}

interface 接口3 {

}
...
```


**示例：**
``` java
interface C extends A, B {

}

interface A {

}

interface B {

}
```

!> 继承会提高代码间的耦合度，降低代码独立性，程序过多的使用继承会导致后期维护困难，所以继承慎用。
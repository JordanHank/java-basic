# 多态

Java 的多态性是同一行为具有多个不同表现形式的能力。而Java 中应用主要是表现在接口上，同一个接口可以有不同的实现方式，这就是多态，但这只是多态应用的一个方面，Java 中多态的应用还有很多，下面将逐一介绍。

## 优点

多态的优点主要是表现在消除和增加两个方面：

+ 消除：可以消除类型间的耦合关系、降低代码耦合度。

+ 增加：增加可扩展性，多态的可替换性、可扩展性、接口性提高了代码灵活性，降低维护成本。

## 实现方式

多态的实现方式主要是以下三种：

+ 函数的重写重载：重写只会发生在函数不会发生在属性上，重写重载函数是的函数的实现不同。

+ 接口的实现：对同一个接口有不同的实现方式。

+ 继承多态实现：通过继承抽象类、继承接口完成同一函数的不同实现。

## 重写(Override)与重载(Overload)

java多态可以通过重写、重载来实现，但是不同的多态性表现。方法重载是同一类的多态性表现；方法重写是父子类的多态性表现。

#### 重写(Override)

重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。**即外壳不变，核心重写！**

``` java
class Child extends Parent {

    @Override
    public void walk() {
        System.out.println("子类重写父类行走方法！");
    }
}

class Parent {

    public void walk() {
        System.out.println("父类行走方法！");
    }
}

```

!> **注意：** 重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常。

``` java
class Child extends Parent {

    //重写doMath 函数不允许抛出比ArithmeticException异常更广泛的异常Exception
    //@Override
    //public void doMath(int x, int y) throws Exception {
    //   ...
    //}
}

class Parent {

    public void doMath(int x, int y) throws ArithmeticException {
        ...
    }
}

```

##### 重写规则

+ 参数列表必须完全与被重写方法的相同。

+ 返回类型必须完全与被重写方法的返回类型相同。

+ 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。

+ 父类的成员方法只能被它的子类重写。

+ 声明为final的方法不能被重写。

+ 声明为static的方法不能被重写，但是能够被再次声明。

+ 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。

+ 子类和父类不在同一个包中，那么子类只能够重写父类的声明为public和protected的非final方法。

+ 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。

+ 构造方法不能被重写。

+ 如果不能继承一个方法，则不能重写这个方法。

#### 重载(Overload)

重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
最常用的地方就是构造函数的重载。

**构造函数的重载：**
``` java
class Demo {
    
    private String id;
    
    private String name;

    public Demo() {
    }

    public Demo(String id) {
        this.id = id;
    }

    public Demo(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
}
```

**同一个类中同名函数的重载：**
``` java
class Demo {

    public void doTest() {
        //参数为空的doTest函数 无返回值
    }

    public int doTest(int i) {
        //有一个int类型参数的doTest函数 有int类型返回值
        return i;
    }
    
    public void doTest(String j) {
        //有一个String类型参数的doTest函数 无返回值
    }

    public void doTest(int i, String j) {
        //第一个为int类型参数，第二个为String类型参数的doTest函数 无返回值
    }

    public void doTest(String i, int j) {
        //第一个为String类型参数，第二个为int类型参数的doTest函数 无返回值
    }
}
```

##### 重载规则

+ 被重载的方法必须改变参数列表(参数个数或类型不一样)。

+ 被重载的方法可以改变返回类型。

+ 被重载的方法可以改变访问修饰符。

+ 被重载的方法可以声明新的或更广的检查异常。

+ 方法能够在同一个类中或者在一个子类中被重载。

+ 无法以返回值类型作为重载函数的区分标准。

#### 区别

|区别  |  重写| 重载 |
|---| ---| ---|
|参数列表 | 一定相同 | 一定不同 |
|返回类型 | 必须相同 | 可以不同 |
|异常 | 可以减少或删除，一定不能抛出新的或者更广的异常 | 可以声明新的或更广的检查异常 |
|访问控制权限 | 一定不能做更严格的限制（可以降低限制） |  可以修改 |

## 接口实现

不同的对象可以将他们的公共行为抽取更加抽象的概念，这就是接口。比如猫和狗都有叫声的行为，但是猫和狗的叫声却不同，这就可以通过接口实现来完成。

``` java
abstract interface Behavior {

    public void bark();
}

class Cat implements Behavior {

    @Override
    public void bark() {
        System.out.println("喵喵喵...");
    }
}

class Dog implements Behavior {

    @Override
    public void bark() {
        System.out.println("汪汪汪...");
    }
}
```

## 继承多态实现

不同的子类继承同一个抽象父类的时候，可以对父类的抽象方法有不同的实现方式，这也是多态的应用。
``` java
abstract class Parent {
    
    abstract void doSomething();
}

class ChildA extends Parent {

    @Override
    void doSomething() {
        System.out.println("ChildA doSomething!");
    }
}

class ChildB extends Parent {

    @Override
    void doSomething() {
        System.out.println("ChildB doSomething!");
    }
}
```

不同的子接口继承了相同的父接口，然后对子接口进行不同的实现，这就是接口继承的多态应用。
``` java
interface Parent {

    void doSomething();
}

interface ChildA extends Parent {
    
}

interface ChildB extends Parent {
    
}

class A implements ChildA {

    @Override
    public void doSomething() {
        System.out.println("ChildA doSomething!");
    }
}

class B implements ChildB {
    
    @Override
    public void doSomething() {
        System.out.println("ChildB doSomething!");
    }
}
```


# 函数

Java 函数是为了解决某个问题而封装一部分代码便于重复利用的程序,Java 开发过程中会大量的应用函数，好的函数能够重复利用，提高代码的可阅读性。

## 定义

函数的定义格式：

```
访问权限修饰符 修饰符 返回类型 函数名（参数类型 形参1，参数类型 形参2，...) {
    执行代码
    return 返回值;
}
```
+ 修饰符是可选的

    + 访问权限修饰符：public 默认 protect private
    + 修饰符：final(表示方法不能被覆盖）、static(表示方法为静态共享的方法）
    
+ 返回类型，特殊返回类型void，表示没有返回，结束可以不用写return语句

+ 函数名小写字母开头后面的单词首字母大写：如addName，必须是合法的Java [标识符](/grammer/identifier)

+ 参数列表可以有0个或多个参数

## 分类

Java 中函数主要分为四种：

+ 静态函数：静态函数是由static [关键字](/grammer/keyword)修饰的函数，一般通过`类名.函数名`的形式调用。

+ 构造函数：Java [对象](/grammer/objdeclare)创建时使用的函数，默认为无参构造函数。

+ 普通函数：使用最多的函数，主要是将重复代码封装利用，增加可阅读性。

+ main函数：所有Java 类执行时的入口，写法是固定不变的，属于特殊函数。

### 静态函数 :id=static-method

静态函数在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），而不允许访问实例成员变量和实例方法；静态函数
一般通过`类名.函数名`的形式调用，也可用使用`对象名.函数名`的形式调用。
``` java
//静态函数返回两个整数的最大值
public static int findMax(int a, int b) {
        return a > b? a : b;
    }
```

### 构造函数

Java [对象](/grammer/objdeclare)创建时使用的函数，主要分为无参构造函数和有参构造函数两种，如果没有显示的声名构造函数，
默认使用无参构造函数创建对象。

``` java

//User 类
public class User{

    //私有变量用户名
    private String name;

    //包含用户名的构造函数
    public User(String name) {
        this.name = name;
    }

    //无参构造函数
    public User() {
    }
}
```

### 普通函数

普通函数主要分为两种：

+ private 修饰的私有函数，只能在类内部使用。

+ 非 private 修饰的函数，使用范围根据[访问修饰符](/grammer/keyword#access-permission)的不同而有所不同。

``` java

public class Girl {

    //私有属性 名称
    private String name;
    
    //私有属性年龄
    private int age;
    
    //女孩的年龄是秘密 所以只有自己知道 私有函数
    private int getAge() {
        return age;
    }

    //公开函数
    public String getName() {
        return name;
    }
}
```

### main函数

main 函数，又称主函数,是程序执行的入口，其实就是类里的一个特殊函数，main 函数在Java 类中只允许存在一个，并且写法是固定的不允许修改。

固定写法：`public static void main(String [] args)`
+ public：[访问控制修饰符](/grammer/keyword#keyword-type)，声明该类的访问权限为共有的。
+ static：静态修饰符，表明函数是一个[静态函数](#static-method)。
+ void：返回值类型，表示没有返回值。
+ String[] args：形参列表，可以使用命令行编译运行时传递参数，如运行命令：java 类名 参数 参数 ...

``` java
public class HelloWorld {
    
    //main 函数的固定写法
    public static void main(String [] args) {
        System.out.println("Hello world!");
    }

}
```
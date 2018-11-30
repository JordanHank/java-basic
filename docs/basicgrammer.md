# 基本语法

## 大小写敏感

Java严格区分大小写，也就是说标志符Hello与hello在Java中表示不同的东西。

``` java
String Hello = "hello";
String hello = "hello";

System.out.println("虽然Hello与hello值相同，但是却代表不同的变量");
```

## 类名

虽然Java中只要是合法的[标志符](/identifier)都可以作为类名，但是我们一般遵从这样的开发规范：如果由若干个字母或单词组成，首字母应该大写，采用驼峰命名 如：FirstClass。

``` java
//下面两种定义虽然编译不会报错 但是不符合开发规范 所以不推荐使用
class democlass {
    ...
}

class DEMOCLASS {
    ...
}

//正确的命名类名应该使用驼峰命名
class DemoClass {
    ...
}

```

## 源文件名

通常Java源代码会被保存为.java结尾的文件，这样的文件也被叫做源文件，而源文件名命名Java规定必须和类名保持一致，也就是class 后面的单词（class 是Java 关键字后面会讲到），比如clss 
Basic文件名只能是Basic.java不然编译会报错。

``` java
public class Basic {

    public static void main(String [] args) {
        System.out.println("类名为Basic的Java 源文件只能保存为Basic.java");
    }
}
```

## 方法名

只要是符合Java [标志符](/identifier)的词语就可以当做方法名，但是一般开发规范规定方法名首字母小写后面的单词首字母大写，最好取有意义的名称如getName,读名知意。

``` java

//用户类
class User {
    
    //用户名
    private String name;
    
    //读取用户名的方法
    public String getName() {
        return name;
    }

    //设置用户名的方法
    public void setName(String name) {
        this.name = name;
    }

}
```

## 主方法入口

所有java文件编译执行都必须有一个执行入口，不然会导致运行出错。而所有java文件的执行入口都是一样的：public static void main(String [] args)，运行Java文件的时候是运行main主方法{ } 
里面的Java代码。

``` java

public clss Demo {
 /*
 *  编译运行Demo.java文件会抛出错误
 *  提示：
 *  错误: 在类 Demo 中找不到 main 方法, 请将 main 方法定义为:
 *  public static void main(String[] args)
 *  否则 JavaFX 应用程序类必须扩展javafx.application.Application
 */
}
```
!> `public static void main(String [] args)` 是main方法的规定写法，必须这样写。

正确的执行例子可以查看[首页-Hello World 示例](/README#hello-world)
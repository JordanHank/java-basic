# 关键字

在现实生活中我们指代同一类事物的时候，往往是定义了些词语来表示这类事物，比如车、灯、动物、人灯。同样的在Java 中也有这样用处的词语，我们称之为关键字。Java 关键字是指在Java 语言中有特殊含义或者作用的名称，简单点说就是一些单词。

## 分类

Java 关键字根据功能和用途分为以下几种：

+ 访问控制符：private、 默认、 protect、 public

+ 用于定义类、方法、变量的修饰关键字：final、 abstract、 static、 synchronized

+ 用于定义类与类之间的关系：extends、 implements

+ 用于创建实例、或判断：new、 this、 super、 instanceof

+ 用于异常处理：try、 catch、 finally、 throw、 throws

+ 用于包：package、 import

+ 用于定义数据类型：class、 interface、 byte、 short、 int、 long、 float、 double、 char、 boolean、 void

+ 用于定义数值：true、 false、 null

+ 用于控制循环：if、 else、 for、 do、 while、 switch、 case、 default、 break、 continue、 return

## 注意项

关于关键字的使用，有以下几个注意项：

+ Java 关键字不能当做[标识符](/grammer/identifier)用来定义类、接口、方法、变量

+ 关键字并不需要牢记所有的关键字，只需要在使用的时候能够辨别即可

+ 除了关键字以外java还有保留字，例如goto、const等，这些事为了以后扩展使用而保留的特殊字

+ 保留字也不能当做[标识符](/grammer/identifier)用来定义

## 示例

``` java
/*
 *   public 是访问控制符关键字
 *   class 定义类的关键字
 */
public class KeywordDemo {

    /*
     *  private 是访问控制符关键字
     *  String 是String类数据类型的关键字
     */
    private String name;
    
    /*
     *  static 修饰关键字表示属性NAME 是静态属性
     *  final 修饰关键字表示属性NAME的值初始化后不允许修改
     */
     public static final String NAME = "Jordan Zhang";
     
      public String getName() {
            //this 关键字指代当前实例
            return this.name;
      }
}
```
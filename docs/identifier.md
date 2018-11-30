# Java 标志符

Java 标识符是Java 中用来标识某个对象的名称，就想叫一个人我们往往会叫他的名字一样，人的姓名代表了这个人，而标识符代表了Java 中的某个对象，可以是类名、接口名、方法名、或者变量名等，在Java 中要合法的形容某个对象（Java
中万物皆对象）必须使用标志符。

## 组成

+ 标志符由26个英文字母包含大小写（A-Z a-z）、数字（0-9），美元符号（$)以及下划线（_）组成

+ 标志符只能以英文字母（A-Z a-z）、美元符号（$)或者下划线（_）开头

+ 关键字不能用作标识符

+ 标识符是大小写敏感的

## 示例

+ 合法标识符：name、_age、$gender、_no_1

+ 不符合符标识符：
    + ~~123time~~: 数字开头错误
    + ~~hobby@~~ : 使用非法字符@
    + ~~class~~ : 标识符不能使用关键字

``` java
/*
 *   public / class 是Java 关键字，所以不能作为标识符
 *   Demo 是类名标识符
 */
public class Demo {

    /*
     *  private / String 是Java 关键字，所以不能作为标识符
     *  name 是变量标识符
     */
    private String name;
    
    /*
     *  public / static / final / String 是Java 关键字，所以不能作为标识符
     *  Name 是常量标识符，和上面的变量标识符name 代表不同的对象
     */
     public static final String NAME = "Jordan Zhang";
     
     /*
      * public / String / return / this 是Java 关键字，所以不能作为标识符
      * getName 是方法名标识符
      */
      public String getName() {
            return this.name;
      }
}
```
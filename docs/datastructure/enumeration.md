# 枚举

在开发过程中往往有这样的需求，就是要使用一个不改变的定值，这个值就是我们常说的[常量](/grammer/constants?id=常量)。
Java 在1.5版本之前使用常量往往是通过定义类或者接口的方式来实现的。

通过类来定义常量星期：
``` java
class WeekCons {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "SUNDAY";
}
``` 

通过接口定义常量星期：
``` java
interface WeekConsInterface {
    String MONDAY = "MONDAY";
    String TUESDAY = "TUESDAY";
    String WEDNESDAY = "WEDNESDAY";
    String THURSDAY = "THURSDAY";
    String FRIDAY = "FRIDAY";
    String SATURDAY = "SATURDAY";
    String SUNDAY = "SUNDAY";
}
```
!> 但是通过类或者接口的方法定义全局变量有违Java的面向对象的封装特性，增加了代码间的耦合度。

在1.5版本之后引入了枚举的概念，枚举是一个特殊的类，因此它是可拓展的。这意味着它们可以有实例字段、构造器和方法（默认无参构造器不能够被声明并且所有的构造器必须被private修饰）。
这样我们通过枚举就可以更好的定义以及使用常量。

## 定义

枚举的定义使用关键字`enum`来定义，定义方法如下：
``` java
enum 枚举名 {

}
``` 

枚举也可以像普通类一样有自己的成员变量和方法，静态、非静态的都可以，用枚举定义星期可以这样：
``` java
enum WeekEnum {
    MONDAY("MONDAY", 1),
    TUESDAY("TUESDAY", 2),
    WEDNESDAY("WEDNESDAY", 3),
    THURSDAY("THURSDAY", 4),
    FRIDAY("FRIDAY", 5),
    SATURDAY("SATURDAY", 6),
    SUNDAY("SUNDAY", 7);

    private String name ;
    private int index ;

    /**
     * 根据星期的值返回枚举
     *
     * @param index 星期值
     */
    public static WeekEnum fromIndex(int index) {
        for (WeekEnum day : WeekEnum.values()) {
            if (day.getIndex() == index) {
                return day;
            }
        }
        return null;
    }


    private WeekEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
``` 

## 使用

枚举类常常当做常量使用，枚举作为特殊类可以配合`switch`语句使用：
``` java
int index = (int) (Math.random() * 7 + 1);
WeekEnum random = WeekEnum.fromIndex(index);
switch(random) {
    case MONDAY:
        System.out.println(WeekEnum.MONDAY.getName());
        break;
    case TUESDAY:
        System.out.println(WeekEnum.TUESDAY.getName());
        break;
    case WEDNESDAY:
        System.out.println(WeekEnum.WEDNESDAY.getName());
        break;
    case THURSDAY:
        System.out.println(WeekEnum.THURSDAY.getName());
        break;
    case FRIDAY:
        System.out.println(WeekEnum.FRIDAY.getName());
        break;
    case SATURDAY:
        System.out.println(WeekEnum.SATURDAY.getName());
        break;
    case SUNDAY:
        System.out.println(WeekEnum.WEDNESDAY.getName());
        break;
}
```

## Enumeration 接口

枚举类经常会和Enumeration 接口联系起来，不过枚举类（Enum）和接口（Enumeration）是两个完全不同的东西。Enumeration 接口
中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素。不过这种传统接口已被迭代器取代，这里只是介绍作为了解。

#### 常用方法

|方法名  |  作用描述|
|---| ---|
|boolean hasMoreElements( ) | 测试此枚举是否包含更多的元素。 |
|Object nextElement( ) | 如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。|

#### 示例

``` java
public class Demo {
 
   public static void main(String args[]) {
      // 接口定义变量  但是不能直接new使用
      Enumeration<String> days;
      // Vector类实现了Enumeration接口
      Vector<String> dayNames = new Vector<String>();
      dayNames.add("Sunday");
      dayNames.add("Monday");
      dayNames.add("Tuesday");
      dayNames.add("Wednesday");
      dayNames.add("Thursday");
      dayNames.add("Friday");
      dayNames.add("Saturday");
      //elements()返回Enumeration类型
      days = dayNames.elements();
      //判断是否还有更多元素
      while (days.hasMoreElements()){
         //打印枚举的下一个元素
         System.out.println(days.nextElement()); 
      }
   }
}
```

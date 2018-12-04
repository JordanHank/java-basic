# 常量

Java 常量是指在整个Java 代码运行周期内值都不会改变的量。为什么要定义常量？是因为我们在Java 开发过程中总会遇到这样的需求，
我们会频繁的使用Java 程序运行中某个值，既然要经常的使用，我们自然就会想到用一个量来全局的代表这个值，这就引出了常量的定义。

## 分类

Java 常量根据数据类型不同，分为以下几种：

+ 整数常量：所有的整数都可以作为Java 常量，这种常量就是整数常量

+ 小数常量：所有的小数都可以作为Java 常量，这种常量就是小数常量

+ 布尔常量：只有true 和 false 两种值可以当做布尔常量

+ 字符常量：使用单引号''括起来的单个字符可以当做字符常量

+ 字符串常量：使用双引号“”括起来的字符串当做常量的称为字符串常量

+ null常量：只有null(null是一个特殊量，表示空的不存在的量，在java中不会占用内存空间）

## 使用方式

在Java 中定义常量的几种方式（以星期为例）：

1. 接口定义interface

``` java

//使用接口interface的形式定义常量值
interface Weeks {

    String SUNDAY = "SUNDAY";
    String MONDAY = "MONDAY";
    String TUESDAY = "TUESDAY";
    String WEDNESDAY = "WEDNESDAY";
    String THURSDAY = "THURSDAY";
    String FRIDAY = "FRIDAY";
    String SATURDAY = "SATURDAY";

}
```

2. 类定义

``` java
//使用类class的形式定义常量
class WeekConst {

    public static final String SUNDAY = "SUNDAY";
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";

}
```

3.方法定义

``` java
//使用类方法的形式定义常量
class WeekFunConst {

    private static final String SUNDAY = "SUNDAY";
    private static final String MONDAY = "MONDAY";
    private static final String TUESDAY = "TUESDAY";
    private static final String WEDNESDAY = "WEDNESDAY";
    private static final String THURSDAY = "THURSDAY";
    private static final String FRIDAY = "FRIDAY";
    private static final String SATURDAY = "SATURDAY";
    public static String getSunday() {
        return SUNDAY;
    }
    public static String getMonday() {
        return MONDAY;
    }
    public static String getTuesday() {
        return TUESDAY;
    }
    public static String getWednesday() {
        return WEDNESDAY;
    }
    public static String getThursday() {
        return THURSDAY;
    }
    public static String getFirday() {
        return FRIDAY;
    }
    public static String getSaturday() {
        return SATURDAY;
    }

}
```

4. 枚举定义

``` java
//采用枚举的方式定义常量
enum WeekEnum {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```

## 总结

前三种定义常量的方式都是static final 的特性来定义常量的，而枚举是Java 5.0之后新引得
的特殊类，用来特别指代常量。由于Java的面向对象的封装特性，不建议应用全局的变量，这样
会增加代码的耦合度，所以最好的方式就是定义枚举类，这样在使用的地方直接引用定义的枚举类
就可以使用常量，降低了代码的耦合，前三种方式是早期定义枚举的常用方式，但自从引入枚举的
概念后，现在定义常量基本都使用枚举的方式。

``` java
public class Constants {

    public static void main(String [] args) {

        //日历类用于读取当前日期的星期，后面会专门讲
        Calendar calendar = Calendar.getInstance();
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        
        //switch 语句后面也会单独讲到，枚举可以用于switch 语句
        switch(w) {
            case 0:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.SUNDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.SUNDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getSunday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.SUNDAY);
                break;
            case 1:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.MONDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.MONDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getMonday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.MONDAY);
                break;
            case 2:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.TUESDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.TUESDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getTuesday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.TUESDAY);
                break;
            case 3:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.WEDNESDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.WEDNESDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getWednesday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.WEDNESDAY);
                break;
            case 4:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.THURSDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.THURSDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getThursday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.THURSDAY);
                break;
            case 5:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.FRIDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.FRIDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getFirday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.FRIDAY);
                break;
            case 6:
                System.out.println("=====接口======");
                System.out.println("Today is " + Weeks.SATURDAY);
                System.out.println("=====类======");
                System.out.println("Today is " + WeekConst.SATURDAY);
                System.out.println("=====类方法======");
                System.out.println("Today is " + WeekFunConst.getSaturday());
                System.out.println("=====枚举======");
                System.out.println("Today is " + WeekEnum.SATURDAY);
                break;
        }
    }

}
```

!> 注意：常量的定义都采用全大写的方式命名,这是默认的开发规范。
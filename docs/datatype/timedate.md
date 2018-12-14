# 时间日期

Java 中用于操作使用时间日期的类型主要是Date 类和Calender 类。Date 类主要是用来封装当前的时间和日期，而Calender 类则主要是对时间日期进行计算。

## Date 类

Date 类的构造函数主要有以下两种：

+ 获取当前系统时间

+ 通过传入的参数计算获取指定日期，该参数是从1970年1月1日起的毫秒数。

``` java
public Date() {
    this(System.currentTimeMillis());
}

public Date(long date) {
    fastTime = date;
}
``` 

#### 示例

``` java
Date now = new Date(); 

Date after = new Date(1239900); 
```

#### 常用方法

|方法名  |  作用描述|
|---| ---|
|after(Date when) | 比较日期是否在传入的指定日期之后，如果是返回true，否则返回false |
|before(Date when) | 比较日期是否在传入的指定日期之前，如果是返回true，否则返回false |
|compareTo(Date anotherDate) |和指定时间日期进行比较，返回两个时间日期的毫秒数只差 |
|equals(Object obj) | 重写了Object 类的equals方法，比较两个日期的毫秒数，如果相等返回true，否则返回false |
|getTime() | 返回自 1970 年 1 月 1 日 00: 00: 00 GMT 以来此 Date 对象表示的毫秒数 |

``` java
Date now = new Date(); 

Date after = new Date(1239900); 

if (now.after(after)) {
    System.out.println("after日期在now日期之后");
}
if (now.before(after)) {
    System.out.println("after日期在now日期之前");
}
System.out.println("compareTo方法=====================");
if (now.compareTo(after) > 0) {
    System.out.println("after日期在now日期之后");
} else if (now.compareTo(after) == 0) {
    System.out.println("now日期和after日期相等");
} else {
    System.out.println("after日期在now日期之前");
}
System.out.println("equals方法=======================");
if (now.equals(after)) {
    System.out.println("now日期和after日期相等");
}
//返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
long time = after.getTime();
System.out.println("after日期的毫秒数为" + time);
```

#### 格式化日期

格式化日期主要有两种方式：

+ 可以通过SimpleDateFormat 类来格式化日期,或者将字符串日期转换成Date

+ 使用printf 输出格式化日期

**SimpleDateFormat 类：** 专门由于格式化时间日期类，或者将时间日期格式化后的[String 类](/datatype/string)重新转换成Date 类型。
``` java
SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

System.out.println("当前时间为: " + ft.format(new Date()));

String changeTime = "1818-11-11 12:24:34";

Date temp;

try {
    temp = ft.parse(changeTime);
    System.out.println(temp.toString());
} catch (ParseException e) {
    System.out.println("转换出错");
}
```

!> **注意：** 将String 类型转换成Date 类型是可能会抛出ParseException 错误，所以必须处理。

**printf 方法：** 是系统提供的专门用于格式化输出的方法。使用两个字母格式，它以 %t 开头并且以下面表格中的一个字母结尾。

|转换符  |  说明| 示例 |
|---| ---| ---|
|c | 包括全部日期和时间信息| 星期五 十二月 22: 45: 10 CST 2018 |
|F | "年-月-日"格式 | 2018-12-14 |
|D | "月/日/年"格式 | 12/14/2018|
|r | "HH: MM: SS PM"格式（12时制）| 10: 45: 10 下午 |
|T | "HH: MM: SS"格式（24时制）| 22: 45: 10 |
|R | "HH: MM"格式（24时制） | 22: 45 | 

``` java
Date now = new Date();
System.out.printf("全部日期和时间信息：%tc%n", now);
System.out.println();
//f的使用
System.out.printf("年-月-日格式：%tF%n", now);
System.out.println();
//d的使用
System.out.printf("月/日/年格式：%tD%n", now);
System.out.println();
//r的使用
System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", now);
System.out.println();
//t的使用
System.out.printf("HH:MM:SS格式（24时制）：%tT%n", now);
System.out.println();
//R的使用
System.out.printf("HH:MM格式（24时制）：%tR", now);
```
## Calender 类

Calendar类的功能要比Date类强大很多，而且在实现方式上也比Date类要复杂一些。Calendar类是一个抽象类，在实际使用时实现特定的子类的对象，创建对象的过程对程序员来说是透明的，只需要使用getInstance方法创建即可。

#### 创建一个代表系统当前日期的Calendar对象
``` java
Calendar cl = Calendar.getInstance();
```

#### 创建一个指定日期的Calendar对象
``` java
Calendar c1 = Calendar.getInstance();
cl.set(2018, 8, 8);
```

#### Calendar类对象字段类型

|常量  |  说明|
|---| ---| 
|Calendar.YEAR | 年份 |
|Calendar.MONTH | 月份 |
|Calendar.DATE | 日期 |
|Calendar.DAY_OF_MONTH | 日期，和上面的字段意义完全相同 |
|Calendar.HOUR	| 12小时制的小时 |
|Calendar.HOUR_OF_DAY | 24小时制的小时|
|Calendar.MINUTE | 分钟 |
|Calendar.SECOND | 秒钟 |
|Calendar.DAY_OF_WEEK | 星期几 |

``` java
Calendar c1 = Calendar.getInstance();
// 获得年份
int year = cl.get(Calendar.YEAR);
// 获得月份
int month = cl.get(Calendar.MONTH) + 1;
// 获得日期
int date = cl.get(Calendar.DATE);
// 获得小时
int hour = cl.get(Calendar.HOUR_OF_DAY);
// 获得分钟
int minute = cl.get(Calendar.MINUTE);
// 获得秒
int second = cl.get(Calendar.SECOND);
// 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
int day = cl.get(Calendar.DAY_OF_WEEK);
```

**使用示例：**
``` java
Calendar c1 = Calendar.getInstance();
//计算十天后的日期
cl.add(Calendar.DATE, 10);
        
//GregorianCalendar类是Calender类的一个具体实现
GregorianCalendar gcal = new GregorianCalendar();

//判断今年是不是闰年
int g_year = gcal.get(Calendar.YEAR);
if (gcal.isLeapYear(g_year)) {
    System.out.println("今年是闰年");
} else {
    System.out.println("今年不是闰年");
}
```
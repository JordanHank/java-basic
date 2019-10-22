# String 类

Java 程序开发一定会用到的类那就是String 类。String 类不是基本数据类型，而是一种特殊的引用类型，而说到引用类型，想到的一定是通过`new`[关键字](/grammer/keyword)创建，默认值为`null`这两点。

## 定义

String 类的定义使用一般包括两种方式：

+ 通过`""`进行字符串的赋值

+ 通过`new`关键字创建String 对象进行赋值。

``` java
String name = "Jordan";
String name1 = new String("Jordan");
```

## 存储

String 类属于特殊引用类型，在内存中存储的时候String 对象是存储在常量池中的，一般对String 
变量赋值的时候是先判断常量池中时候存在相应的字符串对象，如果存在则直接返回该对象的引用地址；不存在时先创建对象，再将创建对象的应用地址赋值给变量。
以下面的示例讲解下String 类在内存中的存储过程：
``` java
String str1 = "java";
String str2 = "java";
String str3 = new String("java");
String str4 = new String("java");

System.out.println(str1 == str2);		//true
System.out.println(str1 == str3);		//false
System.out.println(str3 == str4);		//false
System.out.println(str3.equals(str4));	//true

//intern 方法可以返回该字符串在常量池中的对象的引用
String str5 = str3.intern();
String str6 = str4.intern();
System.out.println("str5 == str6: " + (str5 == str6)); //true
```

+ `str1 = "java"`JVM 首先检查常量池中是否存在java字符串对象，不存在创建字符串，返回创建对象的内存地址

+ `str2 = "java"`常量池中已经存在java字符串对象，直接返回对象的内存地址

+ `str3 = new String("java")`关键字new首先在堆内存创建Java 字符串对象，
检查常量池中是否已经存在Java字符串对象，
不存在则先创建然后把常量池中的对象内存地址赋值给堆对象的引用，
存在就直接把常量池中的对象内存地址直接给堆内存对象引用，然后返回堆内存对象的内存地址。
    + str3 -> 在常量池中找到了Java 对象 -> 堆内存保存常量池对象的内存地址 -> 返回堆内存地址
    
+ `str4 = new String("java")`返回新的堆内存地址，只是堆内存中保存的还是常量池中的Java 对象的内存地址

!> **注意：** `==`比较的是没存地址，equals()方法比较的是字符串的值，因为String 类重写了equals()方法。

>关于String内存存储的更深入的解析可以查看我的博客[String类的底层实现和内存存储](http://www.jordanzhang.xyz/2018/09/24/String类的底层实现和内存存储)

## 不可变性

String 类是不可以改变的，一旦创建初始化成功，就无法修改它的值。以下是String 的部分源码：

``` java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];

    /** Cache the hash code for the string */
    private int hash; // Default to 0

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -6849794470754667710L;

    /**
     * Class String is special cased within the Serialization Stream Protocol.
     *
     * A String instance is written into an ObjectOutputStream according to
     * <a href="{@docRoot}/../platform/serialization/spec/output.html">
     * Object Serialization Specification, Section 6.2, "Stream Elements"</a>
     */
    private static final ObjectStreamField[] serialPersistentFields =
        new ObjectStreamField[0];

    /**
     * Initializes a newly created {@code String} object so that it represents
     * an empty character sequence.  Note that use of this constructor is
     * unnecessary since Strings are immutable.
     */
    public String() {
        this.value = "".value;
    }
    
    ...
```
观察String类的源码发现，String类其实是对数组的封装，它的值其实是保存在final修饰的数组中，既然是final修饰的那么就表示值不能被修改，当给String
变量在次赋值的时候并不是修改了值本身，而是将新值得对象引用重新赋值给了变量。
``` java
String name = "Jordan Zhang";
//这里并不是把Jordan修改了，只是把changeName的对象引用重新赋值给了name变量
name = "changeName"; 
```

**String真的不可以改变值吗？**

其实可以通过反射来修改String的值，因为保存值得数组变量value只是一个引用，并不是真的值，其实可以通过反射来修改String的值，因为保存值得数组变量value只是一个引用，并不是真的值。
``` java
String test = "changeValueTest";

System.out.println("test的值为： " + test); //test的值为： changeValueTest

//获取String类声明的value字段
Field valueField = String.class.getDeclaredField("value");

//修改value字段的访问权限
valueField.setAccessible(true);

//获取test变量对应的value字段引用保存的数组
char [] val = (char []) valueField.get(test);

//修改val数组的值，改为newValue
String t = "newValue";
char [] n = t.toCharArray();
for (int i = 0; i < val.length; i++) {
    if (i < n.length) {
        val[i] = n[i];
    } else {
        val[i] = '\n';
    }
}
//test变量始终应用的是同一个String对象
//但是对象已经发生了改变，说明可以通过反射实现修改String的值，但是我们一般不这样放
System.out.println("test改变后的值为：" + test); //test改变后的值为：newValue
```

## StringBuffer和StringBuilder

修改String类的值我们不推荐使用反射去处理，而是使用StringBuffer和StringBuilder去处理。tringBuffer和StringBuilder其实底层也是基于数组实现的，不过保存值得数组并不是final修饰的,
所以可以修改其保存的值。
``` java
StringBuffer sb = new StringBuffer("这是一个String");
sb.append(",测试");
System.out.println("sb的值为: " + sb); //sb的值为: 这是一个String,测试
StringBuilder sbu = new StringBuilder("StringBuilder的使用");
sbu.append(",速度快");
System.out.println("sbu的值为：" + sbu); //sbu的值为：StringBuilder的使用,速度快
```
#### StringBuffer和StringBuilder区别
StringBuffer和StringBuilder最大的区别在于，StringBuffer是线程安全的，因为它有Synchronized修饰的同步方法；StringBuilder不是线程安全的，但是速度比StringBuffer
快，一般使用StringBuilder除非强调线程安全使用StringBuffer。

## 常用方法

|方法名  |  作用描述|
|---| ---|
|concat(String str) | 进行字符串拼接返回拼接后的新的字符串，字符串拼接还可以使用`+`进行，`+`更常用|
|equals(Object anObject) | String 类重写了父类Object 的equals方法，比较的是两个字符串的值|
|equalsIgnoreCase(String anotherString) | 忽略大小写比较两个String的值|
|replace(CharSequence target, CharSequence replacement)| 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的|
|replaceAll(String regex, String replacement) | 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串|
|substring(int beginIndex, int endIndex) | 返回一个新字符串，它是此字符串的一个子字符串|
|split(String regex) | 根据给定正则表达式的匹配拆分此字符串|
|toCharArray() | 将此字符串转换为一个新的字符数组|

``` java
String name = "Jordan";
String name1 = "Str";
//String的字符串拼接,一般直接使用+进行拼接
name += "Zhang";
name1 = name.concat("_concat");
System.out.println("name的值拼接后为：" + name); //name的值拼接后为：JordanZhang
System.out.println("name1的值拼接后为：" + name1); //name1的值拼接后为：Str_concat

//String类的常用方法
System.out.println("String比较连个值是否相等：" + name.equals(name1)); //String比较连个值是否相等：false

System.out.println("忽略大小写比较两个String的值：" + name.equalsIgnoreCase(name1)); //忽略大小写比较两个String的值：false

//替换String的值
System.out.println("ang换为111：" + name.replace("ang", "111")); //ang换为111：JordanZh111

System.out.println("将所有c字母改为大写C：" + name1.replaceAll("a", "A")); //将所有c字母改为大写C：Str_ConCat

//截取指定长度的字符串
System.out.println("将String进行截取：" + "String".substring(0, 3)); //将String进行截取：Str

//将字符串根据表达式进行拆分
String hello = "Hello World !";
String [] vh = hello.split("\\s+");
System.out.println("拆分后：");
for(String s: vh) {
    System.out.println(s);
}

//返回char数组
char [] arr = "jordan".toCharArray();
for(char a: arr) {
    System.out.print(a + " ");
}
```
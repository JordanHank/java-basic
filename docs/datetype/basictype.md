# 基本类型

Java 通过使用[变量](/grammer/variable)分配内存空间存储[变量](/grammer/variable)对应的值。也就是说，当创建[变量](/grammer/variable)的时候，需要在内存中申请空间。
内存管理系统根据[变量](/grammer/variable)的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。

Java 将数据类型主要分为两种：内置数据类型和引用数据类型。Java 内置的数据类型又称为基本类型。

## 分类

基本类型主要分为六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。

+ ` byte：` 
    + 表示8位有符号位的以二进制补码表示的整数
    + 最小值-128（-2^7)
    + 最大值127（2^7 -1)
    + 默认值为0

+ ` short：` 
    + 表示16位有符号位的以二进制补码表示的整数
    + 最小值为-32768（-2^15）
    + 最大值为 32767（2^15 - 1）
    + 默认值为0

+ ` int：` 
    + 表示32位有符号位的以二进制补码表示的整数
    + 最小值为-2,147,483,648（-2^31）
    + 最大值为2,147,483,647（2^31 - 1）
    + 默认值为0，一般整数型都采用int表示

+ ` long：` 
    + 表示64位有符号位的以二进制补码表示的整数
    + 最小值为-9,223,372,036,854,775,808（-2^63）
    +最大值为9,223,372,036,854,775,807（2^63 -1）
    + 默认值为0L（也可以是0l的表示，但是小写l容易和数字1搞混，所以默认long型使用L表示）

+ ` float：` 
    + 表示单精度32位、符合IEEE 754标准的浮点数
    + float在存储大型浮点数数组时可以节约空间，默认值为0.00f
    + 由于是单精度的所以不能用来表示货币等精度要求高的数字

+ double：
    + 表示双精度、64位、符合IEEE 754标准的浮点数
    + 浮点数的默认值都是double类型，默认值为0.0d
    + 由于精度问题同样不能表示货币

+ ` char：` 
    + 是一个单一的 16 位 Unicode 字符
    + 最小值是 \u0000（即为0）
    + 最大值是 \uffff（即为65,535）
    + char 数据类型可以储存任何字符

+ ` boolean：` 
    + 表示一位的信息
    + 只有true和false两个值，默认为false
    
## 包装类型

Java 为了能够像其他引用类型一样使用基本类型，提供了8种基本类型对应有8种包装类型：

` Byte、Short、Integer、Long、Float、Double、Character、Boolean` 

将基本类型转换成包装类型的过程称为装箱，而将包装类型转换成基本类型的过程称为拆箱；装箱、拆箱是基本类型和包装类型的特殊转换，不需要主动去转换，Java 会自动处理。
``` java
 Integer num = 32; //装箱
 int t_num = num; //拆箱
 
 //可以通过包装类型获得基本类型的长度、最大值、最小值
 System.out.println("包装类：java.lang.Integer");
 System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
 System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
 System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
```

## 类型转换

类型转换：分为显示类型转换（又称强制类型转换）和隐式类型转换两种。

+ 进行类型转换时必须满足类型兼容不然会报类型转换错误

+ 整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。

+ 转化从低到高: `byte,short,char -> int -> long -> float -> double`

+ boolean型不能进行类型转换

!> **注意：** 在把容量大的类型转换为容量小的类型时必须使用强制类型转换；<br/>&emsp;&emsp;&emsp;&nbsp;在转换过程中可能会造成溢出或者精度缺失

``` java
byte max = (byte)128; //会造成溢出，因为int最大可以存储127
System.out.println("溢出max=" + max);
int min = (int) 3.15f; //会造成精度缺失
System.out.println("缺失min=" + min);

//自动类型转换
char c1='a';//定义一个char类型
int i1 = c1;//char自动类型转换为int
System.out.println("char自动类型转换为int后的值等于"+i1);
char c2 = 'A';//定义一个char类型
int i2 = c2+1;//char 类型和 int 类型计算
System.out.println("char类型和int计算后的值等于"+i2);

//强制类型转化 必须类型兼容
byte x = (byte) 127;
System.out.println("int 127强制转换成byte后值为：" + x);

String binary = "1101";
String ten = TransferScaleUtil.decode2To10(binary);
System.out.println("二进制1101转换为十进制为" + ten);

int seven = 7;
System.out.println("十进制7转换为二进制为" + TransferScaleUtil.encode10To2(seven));
```
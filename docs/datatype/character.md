# Character 类

我们使用单个字符的时候一般都是直接使用`char`类型进行变量赋值，就像下面这样：
``` java
//char类型的变量赋值使用单引号赋值单个字符
char a = 'A';
```
但有时候仅仅使用基本类型是没法很好的操作字符的，比如将字符进行大小写转换，如果使用`char`类型只能这样写：
``` java
//将上面定义的变量a转换成小写
a = 'a';
```
这是我们知道`a`变量是大写的情况，可以这样处理，但更多的情况我们希望不去考虑`a`变量本身，而直接转换大写。这是使用Character 类就会显得很方便。
``` java
//通过Character类转换大写
a = Character.toLowerCase(a)
```
Character 类是基本类型`char`的包装类型，可以像使用普通引用类一样使用，能够更好的操作字符。Character 和`char`类型的转换也会自动的进行拆箱和装箱。

## 转义字符

特殊字符的使用需要借助转义字符，转义字符都是前面带有反斜杠`\`，这样是告诉编译器这个字符具有特殊含义，不要对其进行处理。
常用的转移字符有：

+ `\t`插入`tab`键

+ `\b`插入后退键

+ `\n`换行

+ `\r`回车

+ `\'`插入单引号

+ `\"`插入双引号

+ `\\`插入反斜杠

## 常用方法

|方法名  |  作用描述|
|---| ---|
| isLetter(x) | 判断一个字符是不是字母 |
| isDigit(x) | 判断一个字符是不是数字字符 | 
| isWhitespace(x) | 判断是否是一个空格字符 |
| isUpperCase(x) | 判断一个字符是大写字母 |
| isUpperCase(x) | 判断一个字符是小写字母 |
| toUpperCase(x) | 将一个字符转换成大写字母 |
| toLowerCase(x) | 将一个字符转换成小写字母 |

## 示例

``` java
//Character类的常用方法，都是静态static修饰的方法，可以类名.方法名的形式调用
//判断一个字符是不是字母
char letter = 'A', number = '8';
if (Character.isLetter(letter)) {
    System.out.println(letter +"是字母");
} else {
    System.out.println(letter +"不是字母");
}

//判断一个字符是不是数字字符
if (Character.isDigit(number)) {
    System.out.println(number +"是数字字符");
} else {
    System.out.println(number +"不是数字字符");
}

//判断是否是一个空格字符
String test = "there is whitespace";
char [] chars = test.toCharArray();
for(char temp: chars) {
    if (Character.isWhitespace(temp)) {
        System.out.println("这是一个空格字符");
    }
}

//判断一个字符是大写字母
char upper = 'C', lower = 'z';
if (Character.isUpperCase(upper)) {
    System.out.println(upper + "是一个大写字母字符");
} else {
    System.out.println(upper + "不是一个大写字母字符");
}

//判断一个字符是小写字母
if (Character.isUpperCase(lower)) {
    System.out.println(lower + "是一个小写字母字符");
} else {
    System.out.println(lower + "不是一个小写字母字符");
}

//将一个字符转换成大写字母
System.out.println("g转大写后为" + Character.toUpperCase('g'));

//将一个字符转换成小写字母
System.out.println("G转小写后为" + Character.toLowerCase('G'));
```
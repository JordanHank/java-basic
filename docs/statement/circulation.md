# 循环语句

当程序需要进行大量重复工作的时候，仅仅是使用[顺序语句](/statement/order)会显得代码极其臃肿，可读性差，为了解决这个问题，于是有了循环语句。循环语句简化重复工作的代码量，提高了代码的可阅读性。

## 分类

Java 循环语句主要分三种：

1. `while`循环语句

2. `do ... while`循环语句

3. `for`循环语句

## while 循环：

使用方式：
``` text
while(表达式) {
    //如果表达式为true执行下面的代码，直到表达式为false结束循环
    //如果没有条件使表达式为false则造成死循环
}
```

示例：
``` java
 //计算1到100的总和
int sum = 0;
int start = 1;
while (start <= 100) {
    sum += start;
    start++;
}
System.out.println("1到100的总和为：" + sum);
```

## do ... while 循环：

使用方式：
``` text
do {
    //循环体代码

} while (表达式)
```

`do ... while`循环和`while`循环的区别在于，`do ... while`循环不管表达式是否为`true`都会先执行`do{}`里面的代码，所以无论如何都会执行一次循环体。

示例：
``` java
int x = 0, y = 0;
do {
    System.out.println("x的值为：" + x); //不管后面的条件，先执行一次
    x++;
} while (x < 0);

while (y < 0) {
    System.out.println("y的值为：" + y);  //永远不会执行
    y++;
}
```

## for 循环：:id=for-statement

`for`循环分为普通`for`循环语句和增强`for`循环语句两种。

#### 普通for循环： :id=basic-for

普通`for`循环语句是编写Java 程序中最常用的循环语句，并且支持嵌套使用。使用方式如下：
``` text
for ( 初始化表达式; 条件表达式; 循环后的操作表达式）{
    //循环体

}
```

`for`循环的执行过程：初始化变量，判断变量是否满足条件表达式，如果满足则进入循环，执行循环体代码，不满足退出循环，执行循环体代码后执行操作表达式，再次判断条件表达式是否为`true`，为`true`则继续执行循环体...直到条件表达式为`false`，结束循环。

示例：
``` java
//打印5次hello world
for(int i = 0; i < 5; i++) {
    System.out.println("hello world time" + (i + 1));
}

//for循环嵌套打印99乘法表
for(int i = 1; i < 10; i++) {
    for(int j = 1; j <= i; j++) {
        System.out.print(j + " * " + i + " = " + j * i + '\t');
    }
    System.out.println(" ");
}
``` 

**for循环和while循环的区别：**
+ ` for` 循环的控制变量只在{}作用域中有效，出了{}无法访问到变量

+ ` while` 循环的控制变量定义在循环体的外面，所以出了循环体一样可以访问变量

+ ` for` 循环可以节约内存

+ 无限循环写法 ` for(;;) {} ====   while (true) {}` 

``` java
int sumNum = 0;
for(int i = 0; i < 3; i++) {
    sumNum += (i + 1);
    //出了循环体无法访问变量i, 因为变量i的作用域只在循环体内
}
System.out.println("无法访问变量i");

int index = 0;
while (index < 3) {
    index++;
}
//while循环体外面一样可以访问变量index
System.out.println("index的值为:" + index);
```

#### 增强型for循环:  :id=foreach

Java5 引入了一种主要用于数组的增强型 for 循环。使用方式如下：
``` text
for(声名语句：表达式） {
    //循环体
}
```

!> 注意：表达式必须是数组，或者返回数组的方法，声名表达式中变量必须和数组元素的类型相同，并且变量的作用域只能在循环体内

示例：
``` java
int arr[] = {1, 2, 3, 4};
for(int i : arr) {
    System.out.println("i的值依稀为：" + i);
}
```

## 循环控制

循环体会根据表达式一直执行循环代码，如果想要结束循环，只能通过[关键字](/grammer/keyword)`break`和`continue`控制循环结束。

+ `break：`
    + 主要用在循环语句或者`switch`语句中，用来跳出整个语句块。
    + 跳出最里层的循环，并且继续执行该循环下面的语句。
    
+ `continue：` 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。

`break`和`continue`都可以结合标签使用。

示例：
``` java
//break;结束循环 打印0 1 2 （3后面的都不打印）
for(int i = 0; i < 5; i++) {
    if(i == 3) {
        System.out.println("结束循环");
        break;
    }
    System.out.println("当前值为：" + i);
}
//continue结束本次循环 打印 0 1 2 4（跳过了3）
for(int i = 0; i < 5; i++) {
    if(i == 3) {
        System.out.println("结束循环");
        continue;
    }
    System.out.println("当前值为：" + i);
}

//结合标签使用
System.out.println("============break用法========");
outer:for(int i = 0; i < 3; i++) {
    inner:for(int j = 0; j < 3; j++) {
        if (j == 2) {
            break outer;
        }
        System.out.println("j的值为：" + j);
    }
    System.out.println("i的值为：" + i);
}

System.out.println("============continue用法========");
outer:for(int i = 0; i < 3; i++) {
    inner:for(int j = 0; j < 3; j++) {
        if (j == 2) {
            continue outer;
        }
        System.out.println("j的值为：" + j);
    }
    System.out.println("i的值为：" + i);
}
```
!> 标签：是嵌套循环语句中表明嵌套层级关系而使用的别名。

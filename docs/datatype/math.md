# Math 类

Math类用于执行基本数学运算，包括常见的加减乘除、正弦、余弦、平方等。<br/>由于Math的所有方法都是static 静态的，所以可以直接类名.方法的形式调用，如Math.abs()。

## 常用方法

|方法名  |  作用描述|
|---| ---|
|random()  |  随机生成0到1之间的double数  | 
|max(a, b)  |  返回a,b两个数之间的较大值，支持int long float double类型  |
|min(a, b)  |  返回a,b两个数之间的较小值，支持int long float double类型  |
|abs(x)  |  返回一个数的绝对值，支持int long float double类型  |
|ceil(x)  |  返回大于等于( >= )给定参数的的最小整数，返回double 类型  |
|floor(x)  |  返回小于等于（<=）给定参数的最大整数，返回double 类型  |
|round(x)  |  返回给定参数四舍五入后的整数，返回double 类型  |
|pow(a, b)  |  返回a的b次方，返回double 类型  |
|sqrt(x)  |  返回给定参数的算数平方根，返回double 类型  |

## floor, round 和 ceil 方法实例比较

|参数  |  Math.floor| Math.round | Math.ceil|
|---| ---|---| ---|
|1.4 | 1 | 1 | 2|
|1.5 |  1 | 2 | 2|
|1.6 |  1 | 2 | 2|
|-1.4 |  -2 | -1 | -1|
|-1.5 |  -2 | -1 | -1|
|-1.6 |  -2 | -2 | -1|


## 示例
``` java
//生成0到1的随机数（常用）
double randomNum = Math.random();
if (Math.max(0.5, randomNum) == randomNum) {
    System.out.println("随机数大于二分之一");
}

//比较两个相同类型的数的较大值 支持int long float double类型
//参数不管先后顺序，只返回较大的那个数
int a = 34, b = 45;
System.out.println("a和b中的较大值为" + Math.max(a, b));
System.out.println("a和b中的较大值为" + Math.max(b, a));

//比较两个相同类型的数的较小值 同max方法类似
System.out.println("a和b中的较小值为" + Math.max(a, b));

double x = randomNum * 4;
System.out.println("x的值为 " + x);
System.out.println("=================");
//返回一个数的绝对值 返回值类型包括int long float double
System.out.println("x的int绝对值为" + (int) Math.abs(x));
System.out.println("x的long绝对值为" + (long) Math.abs(x));
System.out.println("x的double绝对值为" + (double) Math.abs(x));
System.out.println("x的float绝对值为" + (float) Math.abs(x));

//返回大于等于( >= )给定参数的的最小整数
System.out.println("x的最小整数位" + Math.ceil(x));

//返回小于等于（<=）给定参数的最大整数
System.out.println("x的最大整数位" + Math.floor(x));

//给定参数四舍五入后的整数
System.out.println("x四舍五入后的整数为" + Math.round(x));

//算一个参数的次方 返回double类型
System.out.println("3的5次方为" + Math.pow(3, 5));

//求给定参数的算数平方根 返回double类型
System.out.println("81的算数平方根为" + Math.sqrt(81));
```
# Exception 类

 异常是程序开发中经常会遇到的一些错误，有些错误可以避免，有些无法避免。比如说，你在编写代码的时候少写了一个分号，那么编译的时候会抛出java.lang.Error；或者你在进行类型转换的时候，给`int `
 类型变量赋值字符串，会抛出不兼容的类型的Error。
 
 异常发生的原因有很多，通常包含以下几大类：
 
 + 用户输入了非法数据。
 
 + 要操作的文件或资源不存在。
 
 + 网络通信时连接中断，或者JVM内存溢出。
 
 
 ## 分类
 
 Java 中异常分为三类：
 
 + 检查期异常：检查期异常是用户错误或者问题引起的异常，程序员无法预见。
 
 + 运行期异常：编译期被忽略，只有在运行期才能检查到的错误，可以被程序员避免。
 
 + 错误：错误不是异常，无法受程序员控制，错误通常不会再代码中检查的到。
 
## Java 内置异常类
 
Java 语言定义了一些异常类在 java.lang 标准包中。标准运行时异常类的子类是最常见的异常类。由于 java.lang 包是默认加载到所有的 Java 程序的，所以大部分从运行时异常类继承而来的异常都可以直接使用。

**下面是几种开发过程中常遇到的内置异常：**
 
 + `ArrayIndexOutOfBoundsException` 数组越界
 
 + `ClassCastException` 类型强转异常
 
 + `NullPointerException` 空指针异常
 
 + `NumberFormatException` 字符串转数字错误
 
## 自定义异常类

除了Java 内置异常类以外，如果想要定义自己的异常类也是可以的。因为所有异常都必须是 Throwable 
的子类，所以自定义异常只能通过继承Throwable 或者他的子类Exception 来实现。自定义检查性异常类需要继承Exception 类，运行期异常类需要继承RuntimeException。

**定义：**
``` java
class  自定义异常类 extends 异常类型(Exception){

    // 因为父类已经把异常信息的操作都完成了，所在子类只要在构造时，将异常信息传递给父类通过super 语句即可。
    // 重写 有参 和 无参  构造方法
}
```

**示例：**

``` java
class MyException extends Exception {

    protected String errName;

    protected String errCode;

    protected String errDesc;

    public MyException(Throwable cause, String errName, String errCode, String errDesc) {
        super(cause);
        this.errName = errName;
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public MyException(String message, Throwable cause, String errName, String errDesc) {
        super(message, cause);
        this.errName = errName;
        this.errDesc = errDesc;
    }

    public MyException(String message, String errName) {
        super(message);
        this.errName = errName;
    }

    public MyException(String errName) {
        this.errName = errName;
    }

}
```
 
## 异常处理
 
异常处理主要是两种方式：

+ `try catch` 处理。

+ `throws/throw` 关键字使用。

#### try catch 处理

`try catch`捕获异常就是将可能会产生异常的代码用`try`关键字包裹起来，然后`catch`关键字包裹异常发生时的处理代码。

``` java
try {
    //可能会发生异常的代码
} catch (Exception类型 e) {
    //处理异常 或者打印异常信息 便于追踪异常
}
```

通常`try catch`语句可以结合`finally`关键字使用，`finally`关键字包裹的代码表示最终会执行的代码，不管是否发生异常，这种操作往往是进行网络通信或者文件操作时使用，用于关闭资源。

``` java
try {
    //可能会发生异常的代码
} catch (Exception类型 e) {
    //处理异常 或者打印异常信息 便于追踪异常
} finally {
    //无论是否发生异常，finally 代码块中的代码总会被执行。
    //一般用于关闭资源，或者尝试处理某个异常，是程序恢复正常，但是不一定成功
}
```

`try cath` 代码允许嵌套使用，也就是说可以在任意`try cath` 代码块中继续使用`try cath` 语句，下面是`try cath`语句使用的综合示例：

``` java
//数组越界示例 抛出ArrayIndexOutOfBoundsException异常
int [] arr = {3, 12};
try{ 
    // try 代码块
    System.out.println("arr数组第三个元素的值为:" + arr[2]);
} catch (ArrayIndexOutOfBoundsException e){
    //catch 代码块
    System.out.println("抛出异常：" + e);
    //打印异常路径
    e.printStackTrace();
    //try catch 语句嵌套使用
    try {
        //抛出自定义异常
        throw new MyException("抛出自定义异常");
    } catch (MyException e1) {
        System.out.println(e1.errName);
    }
} finally {
    //finally 代码块
    System.out.println("执行finally代码");
    //改变数组的值
    int [] new_arr = new int[3];
    for (int i = 0; i < arr.length; i++) {
        new_arr[i] = arr[i];
    }
    new_arr[2] = 6;
    arr = new_arr;
    System.out.println("arr数组第三个元素的值为:" + arr[2]);
}
System.out.println("==========================");
System.out.println("arr数组第三个元素的值为:" + arr[2]);
```

#### throws/throw 关键字使用

`throws`关键字抛出异常，抛出的异常类必须是发生的异常的类型或者其父类，抛出某种异常表示发生该种异常的时候不对异常进行处理，直接抛出让程序可以继续正常运行。`throws `
关键字在函数名后面时候，然后后面紧跟抛出的异常类型，可以跟多种异常类型，只需要用`,`隔开表示就行。定义方法如下：

``` text
访问权限修饰符 修饰符 返回类型 函数名（参数类型 形参1,参数类型 形参2,...) throws 异常类型1,异常类型2,... {
    执行代码
    return 返回值;
}
``` 
**示例：**
``` java
//计算两个整数的商
private static float dividNum(int x, int y) throws ArithmeticException {
    float result = (float) x / (float) y;
    return result;
}
```

`throw`关键字表示主动抛出某个异常，不对抛出的异常进行处理，但是抛出的异常也需要进行捕获，所以`throw`关键字不能单独使用，必须结合`try catch`语句或者`throws`关键字使用。

**throw 关键字结合try catch使用：**
``` java
try {
    //主动抛出空指针异常NullPointerException，异常在catch 中处理
    throw new NullPointerException();
} catch (NullPointerException e) {
    //打印异常信息
    e.printStackTrace();
}
```

**throw 关键字结合throws 关键字使用：**
``` java
//handleException方法可能会产生多种异常所以依次抛出
private void handleException() throws NullPointerException, 
    ClassNotFoundException, ClassCastException {
    //主动抛出ClassNotFoundException
    throw new ClassNotFoundException();
}
``` 
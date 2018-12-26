# Stack 类

Stack类是Vector类的一个子类，它实现了一个标准的后进先出（LIFO）的栈。
Stack类只能从一端进行插入（称为 “压栈” ） 或删除 （称为“出栈”）数据的操作。
栈中主要存放一些基本类型的变量数据（`int, short, long, byte, float, double, boolean, char`）和对象句柄(引用)。
栈的应用主要是进行符号匹配。

## 优缺点

+ 优势：存取速度比堆要快，仅次于寄存器，栈数据可以共享。

+ 缺点：存在栈中的数据大小与生存期必须是确定的，缺乏灵活性。

## 构造函数

堆栈只定义了默认构造函数，用来创建一个空栈。
``` java
Stack()
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|boolean empty() | 测试堆栈是否为空 |
|E peek() | 查看堆栈顶部的对象，但不从堆栈中移除它|
|E pop() | 移除堆栈顶部的对象，并作为此函数的值返回该对象 |
|E push(E item) | 把项压入堆栈顶部 |
|int search(Object o) | 返回对象在堆栈中的位置，以 1 为基数|

## 示例

``` java
public class StackIntro {

    public static void main(String [] args) {

        //除了继承自Vector类的方法以外，Stack类还有自己特有的方法
        //堆栈只定义了默认构造函数，用来创建一个空栈。
        Stack stack = new Stack();

        //向栈中添加元素
        stack.push(111);
        stack.push(1.23232);
        stack.push("sfdf");
        stack.push(new Object());

        //查看栈顶元素
        Object obj = stack.peek();
        System.out.println(obj);

        //移除栈顶元素
        Object obj1 = stack.pop();
        System.out.println(obj1);
        System.out.println("obj equals obj1: " + obj.equals(obj1));

        //判断栈是否为空
        if (!stack.empty()) {
            //查找元素下标
            int index = stack.search(111);
            if (index > -1) {
                System.out.println("stack中有111");
            } else {
                System.out.println("stack中没有111");
            }
            index = stack.search(11111);
            if (index > -1) {
                System.out.println("stack中有11111");
            } else {
                System.out.println("stack中没有11111");
            }
        } else {
            System.out.println("stack是空栈");
        }
    }
}
```
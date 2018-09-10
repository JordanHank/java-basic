package com.blackj.leran.java.statement;

/**
 * Program Name: java-basic
 * <p>
 * Description: java循环语句
 * <p>
 * Created by Zhang.Haixin on 2018/9/10
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class CirculationStatement {

    /**
     * java循环语句主要分三种：
     * 1.while循环语句
     * 2.do ... while循环语句
     * 3.for循环语句
     */
    public static void main(String[] args) {

        /**
         * while循环：
         *      while(表达式) {
         *          //如果表达式为true执行下面的代码，直到表达式为false结束循环
         *          //如果没有条件使表达式为false则造成死循环
         *
         *      }
         */

        //计算1到100的总和
        int sum = 0;
        int start = 1;
        while (start <= 100) {
            sum += start;
            start++;
        }
        System.out.println("1到100的总和为：" + sum);

        /**
         * do ... while循环：
         *      do {
         *          //循环体代码
         *
         *      } while (表达式)
         *
         *      do ... while循环和while循环的区别在于，do ... while 循环不管表达式是否
         *      为true都会先执行do{}里面的代码，所以无论如何都会执行一次循环体
         */
        int x = 0, y = 0;
        do {
            System.out.println("x的值为：" + x); //不管后面的条件，先执行一次
            x++;
        } while (x < 0);

        while (y < 0) {
            System.out.println("y的值为：" + y);  //永远不会执行
            y++;
        }

        /**
         * for循环：
         *      for ( 初始化表达式; 条件表达式; 循环后的操作表达式）{
         *          //循环体
         *
         *      }
         *      for循环的执行过程：初始化变量，判断变量是否满足条件表达式，如果满足则
         *      进入循环，执行循环体代码，不满足退出循环，执行循环体代码后执行操作表达式，
         *      再次判断条件表达式是否为true，为true则继续执行循环体...直到条件表达式为false，
         *      结束循环。
         */
        //打印5次hello world
        for(int i = 0; i < 5; i++) {
            System.out.println("hello world time" + (i + 1));
        }

        /**
         * for循环和while循环的区别：
         *      for循环的控制变量只在{}作用域中有效，出了{}无法访问到变量
         *      while循环的控制变量定义在循环体的外面，所以出了循环体一样可以访问变量
         *      所以for循环可以节约内存
         *
         *      无限循环写法 for(;;) {} ====   while (true) {}
         */
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
        System.out.println("index的值为:" + index);

        /**
         * 增强型for循环:
         *      for(声名语句：表达式） {
         *          //循环体
         *      }
         *      表达式必须是数组，或者返回数组的方法
         *      声名表达式中变量必须和数组元素的类型相同，并且变量的作用域只能在循环体内
         */
        int arr[] = {1, 2, 3, 4};
        for(int i : arr) {
            System.out.println("i的值依稀为：" + i);
        }
        //for循环嵌套打印99乘法表
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + j * i + '\t');
            }
            System.out.println(" ");
        }

        /**
         * break和continue控制循环结束
         * break 主要用在循环语句或者 switch 语句中，用来跳出整个语句块。
         * break 跳出最里层的循环，并且继续执行该循环下面的语句。
         *
         * continue 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。
         *
         * 都可以结合标签使用
         */
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
    }
}

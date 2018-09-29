package com.blackj.leran.java.datetype;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 异常类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/29
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ExceptionClass {

    /**
     * 异常是程序开发中经常会遇到的一些错误，有些错误可以避免，有些无法避免。
     * java中异常分为三类：
     *      检查期异常：检查期异常是用户错误或者问题引起的异常，程序员无法预见。
     *      运行期异常：编译期被忽略，只有在运行期才能检查到的错误，可以被程序员避免。
     *      错误：错误不是异常，无法受程序员控制，错误通常不会再代码中检查的到。
     *
     * 常遇到的几种异常：ArrayIndexOutOfBoundsException 数组越界
     *                   ClassCastException 类型强转异常
     *                   NullPointerException 空指针异常
     *                   NumberFormatException 字符串转数字错误
     * 异常处理可以在方法上使用throws关键字抛出异常，抛出的异常类必须是发生的异常的类型或者其父类
     * 也可以使用throw关键字主动抛出某个异常，但是抛出的异常也需要进行捕获
     *
     * 捕获异常：try catch捕获异常可以捕获多重异常try catch catch catch...
     *      try {
     *
     *      } catch (Exception类型 e) {
     *
     *          //处理异常 或者打印异常信息 便于追踪异常
     *      } finally {
     *
     *         //无论是否发生异常，finally 代码块中的代码总会被执行。
     *         //一般用于关闭资源，或者尝试处理某个异常，是程序恢复正常，但是不一定成功
     *      }
     */
    public static void main(String [] args) {

        //数组越界示例 抛出ArrayIndexOutOfBoundsException异常
        int [] arr = {3, 12};
        try{
            System.out.println("arr数组第三个元素的值为:" + arr[2]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("抛出异常：" + e);
            //打印异常路径
            e.printStackTrace();
            try {
                //抛出自定义异常
                throw new MyException("抛出自定义异常");
            } catch (MyException e1) {
                System.out.println(e1.errName);
            }
        } finally {
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
    }
}

//自定义检查性异常类需要继承Exception类，运行期异常类需要继承RuntimeException
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
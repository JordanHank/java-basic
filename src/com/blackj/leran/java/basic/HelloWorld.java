package com.blackj.leran.java.basic;

/**
 * Program Name: java-basic
 * <p>
 * Description: Hello World第一个java程序
 * <p>
 * Created by Zhang.Haixin on 2018/8/30
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class HelloWorld {

    /**
     * 在初学java的时候建议不要借助ide进行代码的编写，最后能够做到手写代码心算运行过程和结果。
     * 可以使用系统自带的文本编辑器或者第三方编辑器进行代码的编写
     * 推荐使用editplus/notepad++等编辑器，因为自带编辑器可能因为编码问题导致运行出错
     *
     *
     * 创建一个HelloWorld.text的文本文件，用编辑器打开编写现在这个文件的代码
     *
     * 即：
     *      public class HelloWorld {
     *          public static void main(String [] args) {
     *
     *           System.out.println("Hello world!");
     *            }
     *      }
     *
     *      另存为HelloWorld.java文件
     *      Ctrl + C 输入cmd进入命令行窗口
     *      输入 cd 文件地址（文件地址可以文件右键查看属性，复制位置）
     *      如果文件不是在c盘,则需要先输入对应盘符加：  如E盘输入 E： 回车 然后在输入上一条命令
     *      输入javac HelloWorld.java回车会生成HelloWorld.class文件
     *      在输入java HelloWorld 可以看到对应的输入 “Hello world!”
     */

    public static void main(String [] args) {

        System.out.println("Hello world!");
        System.out.println("java代码编译执行过程=====================");
        System.out.println("Java不同于C、C++这种底层语言，可以直接编译成机器可以识别的机器码进而执行代码。");
        System.out.println("通过javac命令jvm会将.java文件编译成同名的.class文件，也就是我们所说的字节码文件");
        System.out.println(".class字节码文件也不能直接别机器识别，因为机器只能识别机器码");
        System.out.println("通过java命令执行.class文件就是jvm将字节码文件解释为机器码文件，然后机器识别执行。");
    }
}

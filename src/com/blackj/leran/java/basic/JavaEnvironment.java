package com.blackj.leran.java.basic;

/**
 * Program Name: java-basic
 * <p>
 * Description: java环境配置
 * <p>
 * Created by Zhang.Haixin on 2018/8/30
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class JavaEnvironment {

    /**
     * 学习Java第一步：学会搭建Java开发环境(仅以windows为例，其他系统自行百度）
     * 1.JDK下载地址
     *      http://www.oracle.com/technetwork/java/javase/downloads/index.html
     *      下载之后解压，傻瓜式安装
     * 2.配置环境变量
     *      2.1右击“我的电脑”，选择“属性”，进入“高级系统设置”
     *      2.2点击“高级”选项卡，选择“环境变量”
     *      2.3在系统变量里面添加JAVA_HOME、PATH、CLASSPATH，如果存在则进行编辑，不存在新建
     *          JAVA_HOME：java jdk的安装路径 例如：C:\Program Files (x86)\Java\jdk1.8.0_91
     *          CLASSPATH：.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;   根据JAVA_HOME寻找路径
     *          Path：%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin; 只想Java 的bin目录，以及jre的bin目录
     *      可以通过Ctrl + C 输入cmd 调出命令行界面，然后输入java -version 判断环境是否安装成功
     *      输入：
     *      java version "1.8.0_91"
     *      Java<TM> SE Runtime Environment <build 1.8.0_91-bt14>
     *      Java HostSpot<TM> 64-Bit Server VM <build 25.91-b14, mixed mode>
     *      表示环境安装成功
     */

    public static void main(String [] args) {

        System.out.println("安装Java环境是学习Java开发的第一步！");
        System.out.println("=====================================");
        System.out.println("jdk和jre的区别：");
        System.out.println("jre是java runtime environment, 是java程序的运行环境，包含jvm也就是虚拟机。");
        System.out.println("是编译执行java程序的运行环境。");
        System.out.println("=====================================");
        System.out.println("jdk是java development kit，是java的开发工具包，包含了许多工具和类库。");
        System.out.println("jdk是用来开发的，自带了一个jre是用来执行javac java命令对java文件进行编译执行的。");
        System.out.println("=====================================");
        System.out.println("配置环境变量就是为了设置java程序的开发以及运行环境。");
    }
}

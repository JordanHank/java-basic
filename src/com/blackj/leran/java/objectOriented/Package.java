package com.blackj.leran.java.objectOriented;

/**
 * Program Name: java-basic
 * <p>
 * Description: java包介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/17
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Package {

    /**
     * 为了更好的区分管理类，java引入了包的概念
     * java采用类似于文件夹的形式引入包的概念存储类，并且可以借助报名对类进行区分
     * 即使类名相同，但是包名不同，java也可以区分到底到底引用的是哪个类
     * 包也限定了访问权限，拥有包访问权限的类才能访问某个包中的类。
     * java使用package关键字对类、接口、枚举、注释进行报名区分，防止命名冲突
     *
     * 包名的使用：
     *      package pkg1[．pkg2[．pkg3…]];
     *
     * 为了使用包内的类、接口、枚举、注释，可以通过Import关键字进行相应的导入。
     * 在 java 源文件中 import 语句应位于 package 语句之后，所有类的定义之前，可以没有，也可以有多条，其语法格式为：
     *     import package1[.package2…].(classname|*);
     */
    public static void main(String [] args) {

        System.out.println("将功能类似或者相互联系的类接口通过包管理起来");
        //通常使用小写的字母来命名避免与类、接口名字的冲突。
        System.out.println("包名放在java文件的第一句");
        //包只有在引用包内文件的时候才需要导入
        System.out.println("导入包内文件，需要在包声名之后通过Import导入");
        //导入文件的时候可以只导入需要引入的文件
        System.out.println("也可以通过*通配符导入整个包，这样的话可以使用包内的所有文件");
        //在对.java文件进行编译的时候，会将对应的文件按照报名的对应反路径输出对应的.class文件
        System.out.println("package com.test.Demo.java进行编译");
        //类目录的绝对路径叫做 class path。设置在系统变量 CLASSPATH 中。
        // 编译器和 java 虚拟机通过将 package 名字加到 class path 后来构造 .class 文件的路径。
        System.out.println("会在对应的com目录下test目录下生成Demo.class编译文件");
    }
}

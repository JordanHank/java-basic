package com.blackj.leran.java.grammer;

/**
 * Program Name: java-basic
 * <p>
 * Description: java基础语法
 * <p>
 * Created by Zhang.Haixin on 2018/8/31
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Basic {

    public static void main(String[] args) {
        //首先Java区分大小写，也就是说标志符Hello与hello不同
        String Hello = "hello";
        String hello = "hello";

        System.out.println("虽然Hello与hello值相同，但是却代表不同的变量");

        //类名如果由若干个字母或单词组成，首字母应该大写，采用驼峰命名 如：FirstClass
        //.java文件必须以类名为文件名，也就是class 后面的单词，比如clss Basic文件名只能
        //是Basic.java不然编译会报错，这样的.java文件结尾的文件被称为源文件
        //方法名首字母小写后面的单词首字母大写，最好取有意义的名称如getName,读名知意
        System.out.println("类名必须和文件名同名！");
        System.out.println("编译执行.java文件的时候会先从classpath环境变量目录寻找编译后的.class文件，");
        System.out.println("如果classpath以;结尾，在classpath目录找不到执行的类文件，");
        System.out.println("则在当前目录再次寻找一遍对应的.class类文件。");
        System.out.println("如果没有配置;结尾，则不会在当前目录寻找，");
        System.out.println("而没有配置classpath则只在当前目录寻找。");

        //所有java文件编译执行都必须有一个执行入口，不然会导致运行出错
        /*
        提示：
            错误: 在类 Demo 中找不到 main 方法, 请将 main 方法定义为:
            public static void main(String[] args)
            否则 JavaFX 应用程序类必须扩展javafx.application.Application
         */
        System.out.println("所有java文件的执行入口都是一样的：");
        System.out.println("public static void main(String [] args)");
        System.out.println("都是执行main方法里面的java代码。");
    }
}

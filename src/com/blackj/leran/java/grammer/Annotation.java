package com.blackj.leran.java.grammer;

/**
 * Program Name: java-basic
 * <p>
 * Description: Java注释
 * <p>
 * Created by Zhang.Haixin on 2018/8/31
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Annotation {

    /**
     * java注释主要是用来描述java程序的描述性语句，注释语句并不会被编译
     * java代码是给程序员读的，所以有必要加上适当的注释提高代码的可阅读性
     *      目前java注释分为三种
     *          1.单行注释：使用//进行注释，后面的整行文字都是注释内容
     *          2.多行注释：使用/* 这样的注释，*号包裹的都是注释内容
     *          3.文档注释：文档注释主要是javadoc用来生成统一的可阅读的说明文档
     *          --使用方法：javadoc -D 制定文档存储地址 -version-author(可选） 目标文件
     *          主要包含：@author 作者
     *                  ：@param 参数列表
     *                  ：@return 返回值
     *                  ：@version 版本号
     */

    /**
     *
     * @author Jordan Zhang
     * @version 1.0.0
     * @param name 文档名
     * @return 返回成功
     */
    public String setDoc(String name) {
        System.out.println("这是文档注释的示例");
        return "success";
    }

    public static void main(String [] args) {
        //只是注释  //还可以使用  //多次使用没问题
        System.out.println("当行文本可以嵌套使用");

        /**
         * 这是多行注释
         * 多行
         * 多
         */
        System.out.println("多行注释不允许嵌套使用，因为/*和*/必须成对出现，出现*/就是结尾的地方");

        System.out.println("文档注释主要用于方法，对方法的使用进行说明，包括参数、返回值以及异常");
    }
}

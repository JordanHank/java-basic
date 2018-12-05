package com.blackj.leran.java.datatype;

import java.util.Scanner;

/**
 * Program Name: java-basic
 * <p>
 * Description: Scanner类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/28
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ScannerClass {

    /**
     * java.util.Scanner 是 Java5 的新特征，可以通过 Scanner 类来获取用户的输入或者读取文件内容。
     */
    public static void main(String [] args) {
        //获取用户输入
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数据：");

        //hasNext()方法判断是否还有输入
        if (scanner.hasNext()) {

            //判断输入的是否为整数
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println("输入的整数为：" + num);
            } else if (scanner.hasNextFloat()) { //判断输入的是否为小数
                float num = scanner.nextFloat();
                System.out.println("输入的小数位：" + num);

            }
            //获取输入数据 next()方法不包含空格的字符串
            String str = scanner.next();
            //输入 Jordan Zhang
            System.out.println("输入的是：" + str); //结果是：输入的是：Jordan

            //nextLine()获取一行数据  可以包含空格
            //String str = scanner.nextLine();
            //System.out.println("输入的是：" + str); //结果是：输入的是：Jordan Zhang
        }

        scanner.close();

       /**
        //Scanner类读取文件内容
        File file = new File("test.txt");
        Scanner scanner = null;

        //判断文件是否存在而有内容
        if (file.exists() && file.isFile() && file.length() != 0) {
            try {
                scanner = new Scanner(file);

                //循环读取下一行内容
                while (scanner.hasNextLine()) {
                    String content = scanner.nextLine();
                    System.out.println(content);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        } **/
    }
}

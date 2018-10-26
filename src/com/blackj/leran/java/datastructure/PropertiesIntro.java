package com.blackj.leran.java.datastructure;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Program Name: java-basic
 * <p>
 * Description: java Properties类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/26
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class PropertiesIntro {

    /**
     * Properties 继承于 HashTable.
     * 表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
     * 可以用来获取.properties后缀的配置文件
     *
     * 构造函数：
     *      Properties() //默认无参的构造函数
     *
     *      Properties(Properties propDefault) //指定配置文件的构造函数
     */
    public static void main(String [] args) {

        //创建初始化
        Properties dataBase = new Properties();

        //添加配置项 底层是调用的HashTable的put()方法
        dataBase.setProperty("driver", "com.mysql.jdbc.Driver");
        dataBase.setProperty("url", "jdbc:mysql///user");
        dataBase.setProperty("user", "root");
        dataBase.setProperty("password", "451535");

        //读取配置
        String mysql = dataBase.getProperty("user");
        System.out.println(mysql);
        System.out.println();

        InputStream inputStream = null;
        FileOutputStream outputFile = null;
        OutputStreamWriter osw = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("test.properties"));
            //读取配置文件
            Properties test = new Properties();
            test.load(inputStream);

            Set keyValue = test.keySet();
            for (Iterator it = keyValue.iterator(); it.hasNext();) {
                String key = (String) it.next();
                System.out.println(key + ": " + test.getProperty(key));
            }

            //将配置写入到文件中
            outputFile = new FileOutputStream("test.properties");
            //设置编码格式，防止乱码
            osw = new OutputStreamWriter(outputFile, "utf-8");
            dataBase.store(osw, "配置写入文件测试");
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

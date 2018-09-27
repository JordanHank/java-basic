package com.blackj.leran.java.datetype;

import java.io.*;

/**
 * Program Name: java-basic
 * <p>
 * Description: java IO流介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/27
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class IOStream {

    /**
     * java通过IO操作系统内存实现文件的读写
     * 相关的文件输入、输出流都在java.io包中
     * 常用的输入流有：InputStreamReader、BufferedReader、FileInputStream、BufferedInputStream
     * 输出流有：OutputStreamWriter、BufferedWriter、FileOutputStream、BufferedOutputStream
     */
    public static void main(String [] args) {

        //通过FileInputStream、FileOutputStream实现文件读写
        File file = new File("test.txt");

        //isDirectory()判断file是否是文件夹
        if(file.isFile() && file.exists()){
            //存在先删除文件
            file.delete();
        }
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            //构建FileOutputStream，文件file不存在时会先创建
            fos = new FileOutputStream(file);

            //设置编码格式，防止乱码
            osw = new OutputStreamWriter(fos, "utf-8");

            //通过append()方法写入内容
            osw.append("这是一个测试文件...");

            //换行
            osw.append("\r\n");

            osw.append("This is a test!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //读取test.txt中的文件
        FileInputStream fis = null;

        InputStreamReader isr = null;

        BufferedReader br = null;

        try {
            fis = new FileInputStream(file);

            //设置编码格式
            isr = new InputStreamReader(fis, "utf-8");

            br = new BufferedReader(isr);
            String content = null;
            while((content = br.readLine()) != null)
            {
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

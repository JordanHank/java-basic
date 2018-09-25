package com.blackj.leran.java.datetype;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 时间日期类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/9/25
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class DateClass {

    /**
     * java提供了Date类用于封装当前的日期和时间,Calender类用于计算时间
     */
    public static void main(String [] args) {

        //Date类的使用
        Date now = new Date(); //获取当前时间

        Date after = new Date(1239900); //1239900是指从1970年1月1日起的毫秒数

        System.out.println(now);
        System.out.println(after.toString());

        //Date类的常用方法
        //比较两个日期
        if (now.after(after)) {
            System.out.println("after日期在now日期之后");
        }
        if (now.before(after)) {
            System.out.println("after日期在now日期之前");
        }
        System.out.println("compareTo方法=====================");
        if (now.compareTo(after) > 0) {
            System.out.println("after日期在now日期之后");
        } else if (now.compareTo(after) == 0) {
            System.out.println("now日期和after日期相等");
        } else {
            System.out.println("after日期在now日期之前");
        }
        System.out.println("equals方法=======================");
        if (now.equals(after)) {
            System.out.println("now日期和after日期相等");
        }
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
        long time = after.getTime();
        System.out.println("after日期的毫秒数为" + time);


        //SimpleDateFormat用来格式化日期,或者将字符串日期转换成Date
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间为: " + ft.format(now));

        String changeTime = "1818-11-11 12:24:34";

        Date temp;

        try {
            temp = ft.parse(changeTime);
            System.out.println(temp.toString());
        } catch (ParseException e) {
            System.out.println("转换出错");
        }

        //使用printf输出格式化日期
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n", now);
        System.out.println();
        //f的使用
        System.out.printf("年-月-日格式：%tF%n", now);
        System.out.println();
        //d的使用
        System.out.printf("月/日/年格式：%tD%n", now);
        System.out.println();
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", now);
        System.out.println();
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n", now);
        System.out.println();
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR", now);
        System.out.println();

        //Calender类专门用来计算时间的类
        Calendar cl = Calendar.getInstance(); //获取当前日期

        //创建指定日期
        cl.set(2018, 8, 8);

        // 获得年份
        int year = cl.get(Calendar.YEAR);
        // 获得月份
        int month = cl.get(Calendar.MONTH) + 1;
        // 获得日期
        int date = cl.get(Calendar.DATE);
        // 获得小时
        int hour = cl.get(Calendar.HOUR_OF_DAY);
        // 获得分钟
        int minute = cl.get(Calendar.MINUTE);
        // 获得秒
        int second = cl.get(Calendar.SECOND);
        // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
        int day = cl.get(Calendar.DAY_OF_WEEK);

        //计算十天后的日期
        cl.add(Calendar.DATE, 10);

        //GregorianCalendar类是Calender类的一个具体实现
        GregorianCalendar gcal = new GregorianCalendar();

        //判断今年是不是闰年
        int g_year = gcal.get(Calendar.YEAR);
        if (gcal.isLeapYear(g_year)) {
            System.out.println("今年是闰年");
        } else {
            System.out.println("今年不是闰年");
        }
    }
}

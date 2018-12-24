package com.blackj.leran.java.datastructure;

/**
 * Program Name: java-basic
 * <p>
 * Description: java数据结构枚举类介绍
 * <p>
 * Created by Zhang.Haixin on 2018/10/19
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class EnumerationIntro {

    /**
     * java在1.5版本之前使用常量往往是通过定义类或者接口的方式来实现的
     * 但在1.5版本之后引入了枚举的概念，枚举是一个特殊的类，因此它是可拓展的。
     * 这意味着他们可以有实例字段、构造器和方法（默认无参构造器不能够被声明并且所有的构造器必须被private修饰）
     * 我们通过枚举可以更好的定义以及使用常量
     */
    public static void main(String [] args) {

        /**
         * 通过类或者接口的方法定义全局变量有违Java的面向对象的封装特性，增加了代码间的耦合度。
         */
        System.out.println("类常量定义：" + WeekCons.MONDAY);
        System.out.println("接口常量定义：" + WeekConsInterface.MONDAY);
        //枚举解决了通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性
        System.out.println("枚举常量定义：" + WeekEnum.MONDAY.getName());
        //枚举还可以用在switch语句
        int index = (int) (Math.random() * 7 + 1);
        WeekEnum random = WeekEnum.fromIndex(index);
        switch(random) {
            case MONDAY:
                System.out.println(WeekEnum.MONDAY.getName());
                break;
            case TUESDAY:
                System.out.println(WeekEnum.TUESDAY.getName());
                break;
            case WEDNESDAY:
                System.out.println(WeekEnum.WEDNESDAY.getName());
                break;
            case THURSDAY:
                System.out.println(WeekEnum.THURSDAY.getName());
                break;
            case FRIDAY:
                System.out.println(WeekEnum.FRIDAY.getName());
                break;
            case SATURDAY:
                System.out.println(WeekEnum.SATURDAY.getName());
                break;
            case SUNDAY:
                System.out.println(WeekEnum.WEDNESDAY.getName());
                break;
        }

    }
}

//类的形式定义常量
class WeekCons {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "SUNDAY";
}

//接口定义常量的方法
interface WeekConsInterface {
    String MONDAY = "MONDAY";
    String TUESDAY = "TUESDAY";
    String WEDNESDAY = "WEDNESDAY";
    String THURSDAY = "THURSDAY";
    String FRIDAY = "FRIDAY";
    String SATURDAY = "SATURDAY";
    String SUNDAY = "SUNDAY";
}

//枚举的形式定义常量
enum WeekEnum {
    MONDAY("MONDAY", 1),
    TUESDAY("TUESDAY", 2),
    WEDNESDAY("WEDNESDAY", 3),
    THURSDAY("THURSDAY", 4),
    FRIDAY("FRIDAY", 5),
    SATURDAY("SATURDAY", 6),
    SUNDAY("SUNDAY", 7);

    private String name ;
    private int index ;

    /**
     * 根据星期的值返回枚举
     *
     * @param index 星期值
     */
    public static WeekEnum fromIndex(int index) {
        for (WeekEnum day : WeekEnum.values()) {
            if (day.getIndex() == index) {
                return day;
            }
        }
        return null;
    }


    private WeekEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
package com.blackj.leran.java.datetype;

/**
 * Program Name: java-basic
 * <p>
 * Description: java修饰符
 * <p>
 * Created by Zhang.Haixin on 2018/9/4
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Modifier {

    /**
     * java修饰符主要分访问权限修饰符和非访问权限修饰符两种
     *
     * 访问修饰符：
     *      了解访问修饰符前先要搞清楚，访问修饰符使用来干什么的，顾名思义是用来控制Java类的访问权限的
     *      为什么要控制java类的访问权限？
     *      当我们创建一个java工程的时候如果引用了第三方类库，里面有和我们自己同名的java类的时候，如果
     *      没有区分，程序就分不清楚到底是引用那个Java类了，而区分java类用的是package关键字，
     *      package路径区分java类的唯一性，虚拟机编译执行java文件的时候，就是根据配置的classpath寻找
     *      package路径下的java文件，进行编译执行的，而访问修饰符就是控制Java类的访问权限
     *      访问权限从小到大：
     *      private:只有同类里可见，主要是用来定义属性，私有方法，
     *          是java封装特性的体现，内部可见细节，外部不可使用。
     *      default:默认访问权限，什么也不写，表示同包可见。
     *      protect:表示同包的类和所有子类可见，子类概念后面讲继承的时候会将。
     *      public:表示类可见。
     *
     */

    public static void main(String [] args) {

        System.out.println("访问修饰符注意事项：");
        System.out.println("1.父类中声明为 public 的方法在子类中也必须为 public。");
        System.out.println("2.父类声名的protect的方法在子类中要么是protect要么是public修饰的方法");
        System.out.println("3.父类声名为private的方法，在子类中不能被继承");

        /**
         * 非访问修饰符：
         *      static修饰符，用来修饰变量或者方法表示静态的，
         *      static修饰的变量或者方法可以使用类名.属性名（或者方法）来使用
         *      静态属性存储在静态区，同一个类不管有多少实例，静态属性值只有一份
         *      静态方法不能使用类的非静态变量
         */
        System.out.println("Demo的name值为" + Demo.getName());

        /**
         *      final修饰符，表示不可以改变的。
         *      修饰变量的时候，表示不能重新赋值，只允许赋值一次，常和static一起使用表示常量
         *      修饰方法的时候，表示子类继承不允许覆盖
         */
        System.out.println("demo的father是" + Demo.FATHER);

        /**
         *      abstract修饰符表示抽象的
         *      修饰类时表示抽象类，抽象类可以有非抽象的方法，但是有抽象方法的类必须声明Wie抽象类
         *      修饰方法是表示抽象方法，抽象方法不能有方法体，抽象方法不能用final和static修饰
         *      注意：继承抽象类的子类必须实现所有父类的抽象方法，除非子类也是抽象类。
         */

        /**
         *      synchronized修饰符表示同步的，修饰方法表示同一时间只允许一个线程访问。
         *      transient修饰符当java类进行序列化的时候，被修饰的成员变量会被忽视
         *
         *      volatile修饰符，修饰变量时都强制从共享内存中重新读取该成员变量的值。
         *      而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。
         *      这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
         */
        final VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread(volatileTest);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest.stop();
            }
        });

        thread1.start();
        thread2.start();

    }
}

//抽象类
abstract class Demo {

    //私有属性
    private static String name = "secret";

    //默认属性
    int age;

    //受保护的属性
    protected boolean isKind;

    //公开属性
    public String interest;

    public final double height = 1.72;

    public final static String FATHER = "Mr. Secret";

    public static String getName() {
        return name;
    }

    public void changeHeight() {
        //height = 1.87; 这样会提示无法修改final属性。
    }

    //抽象方法
    abstract void sing();
}

class VolatileTest implements Runnable{
    private volatile boolean flag;

    public void run() {
        flag = true;
        System.out.println("run开始前flag为：" + flag);
        while (flag) {
            //线程执行中
            System.out.println("线程执行中===============");
        }
    }

    public void stop() {
        flag = false;
        System.out.println("flag为" + flag);
    }
}
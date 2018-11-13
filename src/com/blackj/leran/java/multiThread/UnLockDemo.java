package com.blackj.leran.java.multiThread;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 解决死锁示例
 * <p>
 * Created by Zhang.Haixin on 2018/11/13
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class UnLockDemo {

    /**
     * java使用多线程开发，同时操作资源，某个线程占用资源因阻塞无法释放资源而其他线程等待被占用的资源造成自锁
     * 死锁产生的四个必要条件：
     *      互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用
     *      不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放
     *      请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有
     *      循环等待，即存在一个等待队列：P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路
     *
     * 解决死锁方法：一种是用synchronized，一种是用Lock显式锁实现
     *      但是不恰当的使用锁且出现同时要锁多个对象时，也会造成死锁情况
     *
     */

    public static String obj1 = "obj1";

    /**
     * 信号量Semaphore有两种模式，公平模式和非公平模式
     * 公平模式就是调用acquire的顺序就是获取许可证的顺序，遵循FIFO
     * 非公平模式是抢占式的，也就是有可能一个新的获取线程恰好在一个许可证释放时得到了这个许可证，而前面还有等待的线程
     */
    public static final Semaphore a1 = new Semaphore(1);

    public static String obj2 = "obj2";

    public static final Semaphore a2 = new Semaphore(1);


    public static void main(String [] args) {
        //使用信号量解决死锁问题
        //对于无法成功获取的情况，一般就是重复尝试，或指定尝试的次数，也可以马上退出
        LockA lockA = new LockA();
        new Thread(lockA).start();
        LockB lockB = new LockB();
        new Thread(lockB).start();
    }
}


class LockA implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockA 开始执行");
            while (true) {
                //超时1s中之后尝试重新获取许可
                if (UnLockDemo.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + " LockA 锁住 obj1");

                    if (UnLockDemo.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj2");
                        Thread.sleep(60 * 1000); // do something
                    }else{
                        System.out.println(new Date().toString() + "LockA 锁 obj2 失败");
                    }
                }else{
                    System.out.println(new Date().toString() + "LockA 锁 obj1 失败");
                }
                // 释放资源
                UnLockDemo.a1.release();
                UnLockDemo.a2.release();
                // 马上进行尝试，现实情况下do something是不确定的
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockB 开始执行");
            while (true) {
                //超时1s中之后尝试重新获取许可
                if (UnLockDemo.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + " LockB 锁住 obj2");
                    if (UnLockDemo.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj1");
                        Thread.sleep(60 * 1000); // do something
                    }else{
                        System.out.println(new Date().toString() + "LockB 锁 obj1 失败");
                    }
                }else{
                    System.out.println(new Date().toString() + "LockB 锁 obj2 失败");
                }
                // 释放资源
                UnLockDemo.a1.release();
                UnLockDemo.a2.release();
                // 这里只是为了演示，所以tryAcquire只用1秒，而且B要给A让出能执行的时间，否则两个永远是死锁
                Thread.sleep(10 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
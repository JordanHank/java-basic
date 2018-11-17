package com.blackj.leran.java.multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 多线程Semaphore信号量示例
 * <p>
 * Created by Zhang.Haixin on 2018/11/17
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class SemaphoreDemo {

    /**
     * 在java 多线程编程中常常需要处理同步问题，处理同步问题时常用的关键字就是synchronized
     * synchronized的含义就是同步的、互斥的锁，表示同一时刻只能有一个线程能获取执行代码的锁
     * 但是实际情况和应用场景往往是需要多个线程获取锁，并发执行代码，这个时候使用synchronized就不合适了
     * 而java并发工具类中的Semaphore类，就是专门用来处理这种情况的
     *
     * Semaphore构造函数：
     *      public Semaphore(int permits) //默认构造函数，只需要指定许可数量，默认非公平模式。
     *      public Semaphore(int permits, boolean fair) //指定许可数量和是否为公平模式的构造函数
     *
     * Semaphore常用方法：
     *      void acquire():从此信号量获取一个许可前线程将一直阻塞
     *      void acquire(int n):从此信号量获取给定数目许可，在提供这些许可前一直将线程阻塞
     *      void release():释放一个许可，将其返回给信号量
     *      void release(int n):释放n个许可
     *      int availablePermits()：当前可用的许可数
     */
    public static void main(String [] args) {

        List<User> userList = new ArrayList<>(6);
        User user1 = new User("张三");
        userList.add(user1);
        User user2 = new User("李四");
        userList.add(user2);
        User user3 = new User("王五");
        userList.add(user3);
        User user4 = new User("小明");
        userList.add(user4);
        User user5 = new User("小李");
        userList.add(user5);
        User user6 = new User("韩梅梅");
        userList.add(user6);

        //模拟6个用户同时买票
        for (User user: userList) {
            user.start();
        }
    }
}

class User extends Thread{

    // 声明4个窗口窗口
    final static Semaphore windows = new Semaphore(4);

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // 占用窗口
            windows.acquire();
            System.out.println(name + ": 开始买票");
            // 睡2秒，模拟买票流程
            sleep(2000);
            System.out.println(name + ": 购票成功");
            // 释放窗口
            windows.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package com.blackj.leran.java.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 多线程介绍
 * <p>
 * Created by Zhang.Haixin on 2018/11/10
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class MultiThreadIntro {

    /**
     * java 代码是顺序执行的代码，执行由一个进程管理，进程由操作系统分配的内存空间，包含一个或多个线程
     * 一个线程不能独立的存在，它必须是进程的一部分
     * 进程启动后一直运行，直到所有的非守护线程都结束运行后才能结束
     * 线程的声名周期：
     * 新建态 -> （阻塞态） -> 就绪态 -> 运行态 -> 死亡态
     * 新建态：线程创建之后就处于新建态，知道程序start() 启动这个线程
     * 就绪态：线程调用start()方法启动后进入就绪态，知道JVM里线程调度器的调度
     * 运行态：就绪线程获得CPU资源后，执行run()方法进入运行态
     * 阻塞态：线程执行sleep()休眠、suspend（挂起）等方法失去系统资源进入阻塞态，重新获取资源后进入就绪态
     * 阻塞态的三种类型：
     * 等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态
     * 同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)
     * 其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。
     * 当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态
     * 死亡态：线程任务完成或者其他终止条件发生进入死亡态
     * 线程优先级：
     * 其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）
     * 默认优先级 NORM_PRIORITY（5）
     * 优先级高的应该会在优先级低的之前获取到系统资源，但是并不能保证线程执行顺序
     *
     * 多线程并行执行而不是顺序执行，所以使用多线程需要注意几个点：
     *      线程同步安全、线程通信、线程死锁、线程控制（休眠、挂起、停止和恢复）
     *      多线程编程并不是线程越多越好，线程越多CPU上下文切换的时间花费的越多，资源占用越多
     */
    public static void main(String[] args) {

        /**
         * 创建线程的三种方式：
         *      实现Runnable接口
         *      继承Thread类
         *      通过 Callable 和 Future 创建线程
         *
         * 三种方式比较：
         *      实现Runnable/Callable接口的方式更具有扩展性，可以实现其他接口或者继承类
         *      继承Thread类的方式使用简单，获取当前线程直接通过this，无需使用 Thread.currentThread() 方法
         *
         */
        //实现Runnable接口
        RunnableDemo demo = new RunnableDemo("RunnableDemo");

        demo.start();
        System.out.println();

        //继承Thread类
        ThreadChild child = new ThreadChild("ThreadChild");

        child.start();
        System.out.println();

        //通过 Callable 和 Future 创建线程
        CallableThreadDemo ctd = new CallableThreadDemo("CallableThreadDemo");
        FutureTask<Integer> ft = new FutureTask<>(ctd);
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if(i == 3) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class RunnableDemo implements Runnable {

    private String name;

    private Thread thread;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("实现了Runnable接口的类" + name);
        try {
            for(int i = 0; i < 5; i++) {
                System.out.println(name + "线程：" + i);
                // 让线程睡眠一会
                Thread.sleep(50 * i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(name + "线程被打断");
        }
    }

    public void start() {
        System.out.println("启动线程类 " + this.name);
        if(thread == null) {
            thread = new Thread(this, name);
            //使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
            thread.start();
        }
    }
}

class ThreadChild extends Thread {

    private String name;

    private Thread thread;

    public ThreadChild(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("继承了Thread的子类" + name);
        try {
            for(int i = 0; i < 5; i++) {
                System.out.println(name + "线程：" + i);
                // 让线程睡眠一会
                Thread.sleep(50 * i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(name + "线程被打断");
        }
    }

    public void start() {
        System.out.println("启动线程类 " + this.name);
        if(thread == null) {
            thread = new Thread(this, name);
            //改变线程名称，使之与参数 name 相同。
            thread.setName(name);
            //将该线程标记为守护线程或用户线程。
            thread.setDaemon(true);
            //更改线程的优先级。
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }
    }
}

class CallableThreadDemo implements Callable<Integer> {

    private String name;

    public CallableThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("通过 Callable 和 Future 创建线程" + name);
        int i = 10;
        for(; i < 15; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
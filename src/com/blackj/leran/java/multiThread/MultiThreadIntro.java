package com.blackj.leran.java.multiThread;

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
     *
     * 线程的声名周期：
     *  新建态 -> （阻塞态） -> 就绪态 -> 运行态 -> 死亡态
     *  新建态：线程创建之后就处于新建态，知道程序start() 启动这个线程
     *  就绪态：线程调用start()方法启动后进入就绪态，知道JVM里线程调度器的调度
     *  运行态：就绪线程获得CPU资源后，执行run()方法进入运行态
     *  阻塞态：线程执行sleep()休眠、suspend（挂起）等方法失去系统资源进入阻塞态，重新获取资源后进入就绪态
     *      阻塞态的三种类型：
     *          等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态
     *          同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)
     *          其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。
     *                    当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态
     *  死亡态：线程任务完成或者其他终止条件发生进入死亡态
     *
     *  线程优先级：
     *      其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）
     *      默认优先级 NORM_PRIORITY（5）
     *      优先级高的应该会在优先级低的之前获取到系统资源，但是并不能保证线程执行顺序
     *
     */
    public static void main(String [] args) {

    }
}

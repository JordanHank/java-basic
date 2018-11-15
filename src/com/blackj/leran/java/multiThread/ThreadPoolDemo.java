package com.blackj.leran.java.multiThread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 线程池使用示例
 * <p>
 * Created by Zhang.Haixin on 2018/11/15
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ThreadPoolDemo {

    /**
     * Java 提供了四种线程池使用：
     * newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     * newFixedThreadPool 创建一个指定线程数量的线程池，可控制线程最大并发数，超出的线程会在队列中等待
     * newScheduledThreadPool 创建一个指定线程数量的线程池，支持定时及周期性任务执行
     * newSingleThreadExecutor 创建一个单线程化的线程池，单线程执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    public static void main(String [] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            //5个线程同时执行
            executeThread(cachedThreadPool, "cachedThreadPool");
        }

        //关闭线程池，释放资源
        cachedThreadPool.shutdown();

        //指定线程数量为3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            //最多3个线程同时执行
            executeThread(fixedThreadPool, "fixedThreadPool");
        }
        //关闭线程池，释放资源
        fixedThreadPool.shutdown();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            //只有一个线程执行 执行5次
            executeThread(singleThreadExecutor, "singleThreadExecutor");
        }

        //关闭线程池，释放资源
        singleThreadExecutor.shutdown();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        //延迟3秒执行
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("延迟3秒 " + new Date().toString());
            }
        }, 3, TimeUnit.SECONDS);

        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("延迟1秒，每3秒执行1次 " + new Date().toString());
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    private static void executeThread(ExecutorService pool, String poolName) {
        //执行线程
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //打印当前时间
                    System.out.println(poolName + " " +new Date().toString());
                    System.out.println();
                    //休眠线程
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


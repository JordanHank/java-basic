# 线程池

线程池，其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源。

## 分类

Java 提供了四种线程池使用：

+ newCachedThreadPool：创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。

+ newFixedThreadPool：创建一个指定线程数量的线程池，可控制线程最大并发数，超出的线程会在队列中等待。

+ newScheduledThreadPool：创建一个指定线程数量的线程池，支持定时及周期性任务执行。

+ newSingleThreadExecutor：创建一个单线程化的线程池，单线程执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

## 创建

线程池都是通过线程池工厂创建，再调用线程池中的方法获取线程，再通过线程去执行任务方法。

+ `Executors`：线程池创建工厂类。

+ `public static ExecutorService newFixedThreadPool(int nThreads)`：返回线程池对象。

+ `ExecutorService`：线程池类。

+ `Future<?> submit(Runnable task)`：获取线程池中的某一个线程对象，并执行。

+ `Future 接口`：用来记录线程任务执行完毕后产生的结果。线程池创建与使用。

## 示例

``` java
public class ThreadPoolDemo {

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
```

!> 关于线程池类的区别可以查看[java线程池的使用与区别解析](http://www.blackj.site/2018/11/14/java%E7%BA%BF%E7%A8%8B%E6%B1%A0%E7%9A%84%E4%BD%BF%E7%94%A8%E4%B8%8E%E5%8C%BA%E5%88%AB%E8%A7%A3%E6%9E%90/)
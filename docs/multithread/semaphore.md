# Semaphore 类

在Java 多线程编程中常常需要处理同步问题，处理同步问题时常用的关键字就是synchronized，synchronized的含义就是同步的、互斥的锁，表示同一时刻只能有一个线程能获取执行代码的锁，但是实际情况和应用场景往往是需要多个线程获取锁，并发执行代码，这个时候使用synchronized就不合适了，而java并发工具类中的Semaphore类，就是专门用来处理这种情况的。

## 构造函数

Semaphore构造函数：

+ 默认构造函数，只需要指定许可数量，默认非公平模式。

``` java
public Semaphore(int permits)
```

+ 指定许可数量和是否为公平模式的构造函数。

``` java
public Semaphore(int permits, boolean fair)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|void acquire() | 从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断|
|void acquire(int permits) | 从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞，或者线程已被中断|
|void acquireUninterruptibly() | 从此信号量中获取许可，在有可用的许可前将其阻塞|
|void acquireUninterruptibly(int permits) | 从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞|
|int availablePermits() | 返回此信号量中当前可用的许可数|
|int drainPermits() | 获取并返回立即可用的所有许可|
|protected  Collection<Thread> getQueuedThreads() | 返回一个 collection，包含可能等待获取的线程|
|int getQueueLength() | 返回正在等待获取的线程的估计数目|
|boolean  hasQueuedThreads() | 查询是否有线程正在等待获取|
|boolean isFair() | 如果此信号量的公平设置为 true，则返回 true|
|protected  void reducePermits(int reduction) | 根据指定的缩减量减小可用许可的数目|
|void release() | 释放一个许可，将其返回给信号量 |
|void release(int permits) | 释放给定数目的许可，将其返回到信号量 |
|String toString() | 返回标识此信号量的字符串，以及信号量的状态|
|boolean tryAcquire() | 仅在调用时此信号量存在一个可用许可，才从信号量获取许可 |
|boolean tryAcquire(int permits) | 仅在调用时此信号量中有给定数目的许可时，才从此信号量中获取这些许可|
|boolean tryAcquire(int permits, long timeout, TimeUnit unit) | 如果在给定的等待时间内此信号量有可用的所有许可，并且当前线程未被中断，则从此信号量获取给定数目的许可|
|boolean tryAcquire(long timeout, TimeUnit unit) | 如果在给定的等待时间内，此信号量有可用的许可并且当前线程未被中断，则从此信号量获取一个许可|

## 示例

``` java
public class Demo {

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
```

#### 结果

![Semaphore示例结果](../_media/multithread/semaphoreResult.png)

!> 关于Semaphore 类的更多知识可以查看我的博客[Semaphore源码解析](http://www.blackj.site/2018/11/16/Semaphore%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90/)
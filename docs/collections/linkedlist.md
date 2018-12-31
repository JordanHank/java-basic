# LinkedList 类

LinkedList 是一个继承于AbstractSequentialList的双向链表,可以被当作堆栈、队列或双端队列进行操作。

LinkedList 主要实现了下面这些接口：

+ 实现了List接口，可以使用添加、修改、删除遍历等功能。

+ 实现 Deque 接口，即能将LinkedList当作双端队列使用。

+ 实现了Cloneable接口，覆盖了函数clone()，能被克隆。

+ 实现了java.io.Serializable接口，支持序列化，能通过序列化去传输。

!> **注意：** LinkedList是非线程同步的，所以多线程的场景不建议使用。

## 构造函数

+ 默认无参构造函数，构造一个空列表。

``` java
LinkedList()
```

+ 指定Collection的创建，构造一个包含指定 collection 中的元素的列表，这些元素按其 collection 的迭代器返回的顺序排列。

``` java
LinkedList(Collection<? extends E> c)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|boolean add(E e) | 将指定元素添加到此列表的结尾|
|void add(int index, E element)| 在此列表中指定的位置插入指定的元素|
|boolean addAll(Collection<? extends E> c)| 添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序|
|boolean addAll(int index, Collection<? extends E> c)| 将指定 collection 中的所有元素从指定位置开始插入此列表 |
|void addFirst(E e)| 将指定元素插入此列表的开头 |
|void addLast(E e)| 将指定元素添加到此列表的结尾|
|void clear()| 从此列表中移除所有元素 |
|Object clone()| 返回此 LinkedList 的浅表副本|
|boolean contains(Object o)| 如果此列表包含指定元素，则返回 true|
|Iterator<E> descendingIterator() | 返回以逆向顺序在此双端队列的元素上进行迭代的迭代器|
|E element()| 获取但不移除此列表的头（第一个元素）|
|E get(int index)| 返回此列表中指定位置处的元素|
|E getFirst()| 返回此列表的第一个元素|
|E getLast()| 返回此列表的最后一个元素|
|int indexOf(Object o) | 返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1|
|int lastIndexOf(Object o) | 返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1|
|ListIterator<E> listIterator(int index) |  返回此列表中的元素的列表迭代器（按适当顺序），从列表中指定位置开始|
|boolean offer(E e)| 将指定元素添加到此列表的末尾（最后一个元素）|
|boolean offerFirst(E e) | 在此列表的开头插入指定的元素 |
|boolean offerLast(E e) | 在此列表末尾插入指定的元素 |
|E peek() | 获取但不移除此列表的头（第一个元素）|
|E peekFirst() | 获取但不移除此列表的第一个元素；如果此列表为空，则返回 null|
|E peekLast() | 获取但不移除此列表的最后一个元素；如果此列表为空，则返回 null|
|E poll()| 获取并移除此列表的头（第一个元素）|
|E pollFirst()| 获取并移除此列表的第一个元素；如果此列表为空，则返回 null|
|E pollLast()| 获取并移除此列表的最后一个元素；如果此列表为空，则返回 null|
|E pop()| 从此列表所表示的堆栈处弹出一个元素|
|void push(E e) | 将元素推入此列表所表示的堆栈|
|E remove() | 获取并移除此列表的头（第一个元素）|
|E remove(int index)| 移除此列表中指定位置处的元素|
|boolean remove(Object o)| 从此列表中移除首次出现的指定元素（如果存在） |
|E removeFirst() | 移除并返回此列表的第一个元素 |
|boolean removeFirstOccurrence(Object o) | 从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）|
|E removeLast() | 移除并返回此列表的最后一个元素 |
|boolean removeLastOccurrence(Object o) | 从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）|
|E set(int index, E element)| 将此列表中指定位置的元素替换为指定的元素 |
|int size()| 返回此列表的元素数|
|Object[] toArray() | 返回以适当顺序（从第一个元素到最后一个元素）包含此列表中所有元素的数组|
|<T> T[] toArray(T[] a) | 返回以适当顺序（从第一个元素到最后一个元素）包含此列表中所有元素的数组；返回数组的运行时类型为指定数组的类型|

## 示例

``` java
public class Demo {

    public static void main(String [] args) {
        /**
         * LinkedList 实际上是通过双向链表去实现的
         * 内部类Node是双向链表节点所对应的数据结构：当前节点所包含的值，上一个节点，下一个节点
         */
        LinkedList linkedList = new LinkedList();

        //添加元素
        for (int i = 0; i < 10; i++) {
            //属于Collection接口的方法 会抛出异常
            linkedList.add(i);
        }

        //向头部添加元素 属于Collection接口的方法 会抛出异常
        linkedList.addFirst(-1);

        //获取第一个元素 属于Collection接口的方法 会抛出异常
        Object first = linkedList.getFirst();
        System.out.println("linkedList数组的第一个元素是："+ first);
        System.out.println();

        //向尾部添加元素 属于Collection接口的方法 会抛出异常
        linkedList.addLast(100);

        //获取最后一个元素 属于Collection接口的方法 会抛出异常
        Object last = linkedList.getLast();
        System.out.println("linkedList数组的最后一个元素是：" + last);
        System.out.println();

        //移除第一个元素 属于Collection接口的方法 会抛出异常
        Object removeF = linkedList.removeFirst();
        System.out.println("linkedList数组移除第一个元素：" + removeF);
        first = linkedList.getFirst();
        System.out.println("linkedList数组移除第一个元素后第一元素为：" + first);
        System.out.println();

        //移除最后一个元素 属于Collection接口的方法 会抛出异常
        Object removeL = linkedList.removeLast();
        System.out.println("linkedList数组移除最后一个元素：" + removeL);
        last = linkedList.getLast();
        System.out.println("linkedList数组移除最后一个元素后最后一元素为：" + last);
        System.out.println();

        //通过迭代器遍历
        System.out.println("通过迭代器遍历:");
        for (Iterator iterator = linkedList.listIterator(); iterator.hasNext();) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //Deque队列时使用的添加方法 返回boolean值不会抛出异常
        boolean offer = linkedList.offer("offer");
        System.out.println("linkedList当做队列时添加元素offer返回：" + offer);
        System.out.println();

        //向队列添加到头部
        boolean offerF = linkedList.offerFirst("first");
        System.out.println("linkedList当做队列时添加头部元素first返回：" + offerF);
        //获取队列头部元素
        first = linkedList.peekFirst();
        System.out.println("peek linkedList第一个元素：" + first);
        System.out.println();

        //向队列尾部添加元素
        boolean offerL = linkedList.offerLast("last");
        System.out.println("linkedList当做队列时添加尾部元素last返回：" + offerL);
        //获取队列尾部元素
        last = linkedList.peekLast();
        System.out.println("peek linkedList最后一个元素：" + last);
        System.out.println();

        //移除头部元素
        Object pollF = linkedList.pollFirst();
        System.out.println("linkedList数组移除第一个元素：" + pollF);
        //获取第一元素
        first = linkedList.element();
        System.out.println("linkedList数组移除第一个元素后第一元素为：" + first);
        System.out.println();

        //移除尾部元素
        Object pollL = linkedList.pollLast();
        System.out.println("linkedList数组移除最后一个元素：" + pollL);
        last = linkedList.getLast();
        System.out.println("linkedList数组移除最后一个元素后最后一元素为：" + last);
        System.out.println();

        //通过for循环遍历 不推荐使用 速度很慢
        System.out.println("通过for循环遍历:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();

        //LinkedList可以作为LIFO(后进先出)的栈，作为LIFO的栈时
        //添加到头部
        linkedList.push("push");
        System.out.println("linkedList数组的第一元素为：" + linkedList.peekFirst());
        System.out.println();

        //移除头部元素
        Object pop = linkedList.pop();
        System.out.println("linkedList数组移除第一个元素：" + pop);
        System.out.println();

        //for增强循环 推荐使用
        System.out.println("for增强循环：");
        for (Object o: linkedList) {
            System.out.print(o + " ");
        }
        System.out.println();
        System.out.println();

        //拷贝数组
        LinkedList copy = (LinkedList) linkedList.clone();
        LinkedList copy1 = (LinkedList) linkedList.clone();
        LinkedList copy2 = (LinkedList) linkedList.clone();
        LinkedList copy3 = (LinkedList) linkedList.clone();

        /**
         * 下面的遍历方法都会移除原始数据：
         * 使用removeFist()或removeLast()效率最高
         */
        //通过pollFirst()来遍历LinkedList
        System.out.println("通过pollFirst()来遍历LinkedList：");
        do {
            if (copy.size() > 0) {
                System.out.print(copy.getFirst() + " ");
            }
        } while (copy.pollFirst() != null);

        System.out.println();
        System.out.println();

        //通过pollLast()来遍历LinkedList
        System.out.println("通过pollLast()来遍历LinkedList：");
        do {
            if (copy1.size() > 0) {
                System.out.print(copy1.getLast() + " ");
            }
        } while (copy1.pollLast() != null);
        System.out.println();
        System.out.println();

        //通过removeFirst()来遍历LinkedList
        System.out.println("通过removeFirst()来遍历LinkedList：");
        try {
            do {
                if (copy2.size() > 0) {
                    System.out.print(copy2.getFirst() + " ");
                }
            } while(copy2.size() > 0 && copy2.removeFirst() != null);
            System.out.println();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println();

        //通过removeLast()来遍历LinkedList
        System.out.println("通过removeLast()来遍历LinkedList：");
        try {
            do {
                if (copy3.size() > 0) {
                    System.out.print(copy3.getLast() + " ");
                }
            } while(copy3.size() > 0 && copy3.removeLast() != null);
            System.out.println();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
```

关于ArrayList 和 LinkedList 的区别对比，可以参考我的博客[ArrayList和LinkedList的区别比较](http://www.blackj.site/2018/10/30/ArrayList%E5%92%8CLinkedList%E7%9A%84%E5%8C%BA%E5%88%AB%E6%AF%94%E8%BE%83/)
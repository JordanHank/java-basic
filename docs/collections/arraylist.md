# ArrayList 类

ArrayList 是一个数组队列，和数组不同的是能够动态扩容，也就是我们说的动态数组。

ArrayList 类的常用方法基本来自于下面的一继承和三实现：
+ 继承自AbstractLis，有实现了List接口，可以使用添加、修改、删除遍历等功能。

+ 实现了RandomAccess接口，提供随机访问功能，即通过数组下标访问元素。

+ 实现了Cloneable接口，覆盖了函数clone()，能被克隆。

+ 实现了java.io.Serializable接口，支持序列化，能通过序列化去传输。

!> **注意：** 和Vector不同的是ArrayList不是线程安全的，所以涉及多线程的时候不建议使用。

## 构造函数

ArrayList 类有下面三个构造函数：

+ 默认构造函数，底层数组大小默认为10，空间不如时新的容量=“(原始容量x3)/2 + 1”。

``` java
ArrayList() 
```

+ 指定数组大小的构造函数，空间不足时容量会添加上次容量的一般。

``` java
ArrayList(int initialCapacity) 
```

+ 指定Collection的创建，构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。

``` java
ArrayList(Collection<? extends E> c)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|boolean add(E e)| 将指定的元素添加到此列表的尾部|
|void add(int index, E element) | 将指定的元素插入此列表中的指定位置|
|boolean addAll(Collection<? extends E> c)| 按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部|
|boolean addAll(int index, Collection<? extends E> c)| 从指定的位置开始，将指定 collection 中的所有元素插入到此列表中|
|void clear() | 移除此列表中的所有元素|
|Object clone() | 返回此 ArrayList 实例的浅表副本|
|boolean contains(Object o) | 如果此列表中包含指定的元素，则返回 true|
|void ensureCapacity(int minCapacity) | 如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数|
|E get(int index) | 返回此列表中指定位置上的元素|
|int indexOf(Object o)|  返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1|
|boolean isEmpty() | 如果此列表中没有元素，则返回 true |
|int lastIndexOf(Object o)| 返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1|
|E remove(int index)| 移除此列表中指定位置上的元素|
|boolean remove(Object o)| 移除此列表中首次出现的指定元素（如果存在）|
|protected  void removeRange(int fromIndex, int toIndex)|移除列表中索引在 fromIndex（包括）和 toIndex（不包括）之间的所有元素|
|E set(int index, E element)| 用指定的元素替代此列表中指定位置上的元素|
|int size() | 返回此列表中的元素数|
|Object[] toArray()| 按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组|
|<T> T[] toArray(T[] a) | 按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组；返回数组的运行时类型是指定数组的运行时类型|
|void trimToSize()| 将此 ArrayList 实例的容量调整为列表的当前大小|

## 示例

``` java
public class Demo {

    public static void main(String [] args) {
        //默认方式创建初始化
        ArrayList<Integer> array = new ArrayList<Integer>();
        //添加元素
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        //判断集合中是否包含某个元素
        boolean cont = array.contains("name");
        System.out.println("数组array中包含name: " + cont);
        System.out.println();

        //查找元素的下标
        int index = array.indexOf(7);
        if (index > -1) {
            System.out.println("数组array中包含7");
        } else {
            System.out.println("数组array中不包含7");
        }
        System.out.println();

        //判断数组是否为空
        boolean isEmpty = array.isEmpty();
        System.out.println("数组array是空数组：" + isEmpty);
        System.out.println();

        //获取数组的大小
        int size = array.size();
        if (size > 0) {
            System.out.println("数组array不是空数组");
        } else {
            System.out.println("数组array是空数组");
        }
        System.out.println();

        //移除某个元素
        boolean remove = array.remove(new Integer(5));
        System.out.println("删除5返回：" + remove);
        System.out.println();

        Object rev = array.remove(2);
        System.out.println("删除下标为2的元素：" + rev);
        System.out.println();

        //数组拷贝 浅拷贝（如果数组中包含的对象有其他的对象属性并不会拷贝）
        ArrayList<Integer> cloneArray = (ArrayList<Integer>) array.clone();

        //清空数组
        array.clear();
        System.out.println("数组array的大小为：" + array.size());
        System.out.println();

        // 遍历ArrayList时，使用随机访问(即，通过索引序号访问)效率最高
        System.out.println("随机访问遍历数组cloneArray：");
        for (int i = 0; i < cloneArray.size(); i++) {
            //获取元素
            System.out.print(cloneArray.get(i) + " ");
        }
        System.out.println();

        //迭代器进行遍历 效率最低！
        Iterator iterator = cloneArray.iterator();
        System.out.println("迭代器遍历数组cloneArray中包含元素：");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //转换成对象数组 可能会抛出“java.lang.ClassCastException”异常
        Object [] elements = cloneArray.toArray();
        System.out.println("转换的数组对象包括：");
        for (Object o: elements) {
            System.out.print(o + " ");
        }
        System.out.println();

        //泛型数组转换 不会抛出异常 因为明确转换的类型
        Integer[] integerArray = (Integer[]) cloneArray.toArray(new Integer[0]);
        System.out.println("数组integerArray的大小为：" + integerArray.length);
    }
}
```
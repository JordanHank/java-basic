# Hashtable 类

Hashtable 和 HashMap一样也是散列表，用来存储键值对。Hashtable 继承自 Dictionary,实现了Map、Cloneable、java.io.Serializable接口，
可以进行克隆，支持序列化，能通过序列化去传输。Hashtable 是线程同步的，所以它是线程安全的，多线程也可以使用。
Hashtable 的键key 和 值value都不可以是null,存储的映射也不是有序的。

Hashtable 中两个影响性能的参数是：初始容量initialCapacity 和扩充因子loadFactor。

+ 初始容量initialCapacity指定哈希表在创建时的容量。

+ 扩充因子loadFactor用于计算哈希表扩充时的条件（哈希表中的条目数超出了扩充因子与当前容量的乘积时），扩充因子的默认值为0.75。

## 构造函数

Hashtable 的构造函数有以下四种：

+ 默认构造函数， 用默认的初始容量 (11) 和加载因子 (0.75) 构造一个新的空哈希表。

``` java
Hashtable() 
```

+ 指定初始容量的构造函数，用指定初始容量和默认的加载因子 (0.75) 构造一个新的空哈希表。

``` java
Hashtable(int initialCapacity) 
```

+ 指定初始容量和扩充因子的构造函数，用指定初始容量和指定加载因子构造一个新的空哈希表。

``` java
Hashtable(int initialCapacity,float loadFactor) 
```

+ 指定Map集合的构造函数，构造一个与给定的 Map 具有相同映射关系的新哈希表。

## 成员变量

Hashtable 的成员变量：

+ table是一个Entry[]数组类型，而Entry实际上就是一个单向链表用于存储键值对。

+ count是Hashtable 的大小，它是Hashtable保存的键值对的数量。

+ threshold扩充阈值，用于判断HashMap是否需要扩充，threshold的值="容量*加载因子"，达到阈值扩充时HashMap容量加倍。

+ loadFactor就是扩充因子，用于计算扩充阈值。

+ modCount用于计算快速失败机制。

## 常用方法

|方法名  |  作用描述|
|---| ---|
|void clear()| 将此哈希表清空，使其不包含任何键|
|Object clone()| 创建此哈希表的浅表副本|
|boolean contains(Object value) | 测试此映射表中是否存在与指定值关联的键|
|boolean containsKey(Object key) | 测试指定对象是否为此哈希表中的键 |
|boolean containsValue(Object value) | 如果此 Hashtable 将一个或多个键映射到此值，则返回 true |
|Enumeration<V> elements() | 返回此哈希表中的值的枚举|
|Set<Map.Entry<K,V>> entrySet() |返回此映射中包含的键的 Set 视图 |
|boolean equals(Object o) | 按照 Map 接口的定义，比较指定 Object 与此 Map 是否相等 |
|V get(Object key) | 返回指定键所映射到的值，如果此映射不包含此键的映射，则返回 null. 更确切地讲，如果此映射包含满足 (key.equals(k)) 的从键 k 到值 v 的映射，则此方法返回 v；否则，返回 null| 
|int hashCode() | 按照 Map 接口的定义，返回此 Map 的哈希码值 |
|boolean isEmpty() | 测试此哈希表是否没有键映射到值|
|Enumeration<K> keys() | 返回此哈希表中的键的枚举 |
|Set<K> keySet() |  返回此映射中包含的键的 Set 视图|
|V 	put(K key, V value) | 将指定 key 映射到此哈希表中的指定 value |
|void putAll(Map<? extends K,? extends V> t) | 将指定映射的所有映射关系复制到此哈希表中，这些映射关系将替换此哈希表拥有的、针对当前指定映射中所有键的所有映射关系|
|protected  void rehash() | 增加此哈希表的容量并在内部对其进行重组，以便更有效地容纳和访问其元素|
|V remove(Object key) | 从哈希表中移除该键及其相应的值 |
|int size() | 返回此哈希表中的键的数量 |
|String toString() | 返回此 Hashtable 对象的字符串表示形式，其形式为 ASCII 字符 ", " （逗号加空格）分隔开的、括在括号中的一组条目 |
|Collection<V> values() | 返回此映射中包含的键的 Collection 视图 |

## 示例

``` java
public class Demo {

    public static void main(String [] args) {

        //默认初始化
        Hashtable hashTable = new Hashtable();


        //添加元素
        hashTable.put("name", "Jordan Zhang");
        hashTable.put("gender", "man");
        hashTable.put("hobby", "sports");

        //获取元素
        String name = (String) hashTable.get("name");
        System.out.println("name为：" + name);
        System.out.println();

        //克隆 Hashtable
        Hashtable clone = (Hashtable) hashTable.clone();

        //不允许键或者值为空 会抛出空指针异常  java.lang.NullPointerException
//        hashTable.put(null, null);
//        hashTable.put("key", null);
//        hashTable.put(null, "value");

        //判断是否包含键key
        boolean containsKey = hashTable.containsKey("gender");
        if (containsKey) {
            System.out.println("hashTable中包含键gender");
        } else {
            System.out.println("hashTable中不包含键gender");
        }
        System.out.println();

        //判断是否包含值value
        boolean containsValue = hashTable.containsValue(1243);
        if (containsValue) {
            System.out.println("hashTable中包含值1243");
        } else {
            System.out.println("hashTable中不包含值1243");
        }
        System.out.println();

        //获取Hashtable的大小
        int size = hashTable.size();
        System.out.println("hashTable的容量为：" + size);
        System.out.println();

        //通过键移除键值对
        Object ret = hashTable.remove("name");
        System.out.println("移除hashTable中的键为name的键值对返回：" + ret);
        System.out.println("查询hashTable中键为name返回：" + hashTable.get("name"));
        System.out.println();

        //通过键值对移除
        boolean remove = hashTable.remove("gender", "man");
        System.out.println("移除hashTable中的键值对gender-man返回：" + remove);
        System.out.println();

        //清空Hashtable
        hashTable.clear();

        //判断Hashtable是否为空
        if (hashTable.isEmpty()) {
            System.out.println("hashTable容量为空");
        } else {
            System.out.println("hashTable容量不为空");
        }
        System.out.println();

        System.out.println("Hashtable的遍历方法：");
        //迭代器遍历键值对
        System.out.println("迭代器遍历键值对");
        Iterator iterator = clone.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            // 获取key
            String key = (String) entry.getKey();
            // 获取value
            String value = (String) entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过遍历键遍历
        System.out.println("通过遍历键遍历");
        iterator = clone.keySet().iterator();
        while (iterator.hasNext()) {
            // 获取key
            String key = (String) iterator.next();
            // 获取value
            String value = (String) clone.get(key);
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过遍历值遍历 无法获取键key
        System.out.println("通过遍历值遍历");
        Collection collection = clone.values();
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println();

        //通过Enumeration遍历Hashtable的键
        System.out.println("通过Enumeration遍历Hashtable的键");
        Enumeration keys = clone.keys();
        while(keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = (String) clone.get(key);
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过Enumeration遍历Hashtable的值 无法获取键key
        System.out.println("通过Enumeration遍历Hashtable的值");
        Enumeration values = clone.elements();
        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }
    }
}
```

关于HashMap 和 Hashtable 的区别对比，可以参考我的博客[HashMap和Hashtable的区别比较](http://www.jordanzhang.xyz/2018/11/04/HashMap%E5%92%8CHashtable%E7%9A%84%E5%8C%BA%E5%88%AB%E6%AF%94%E8%BE%83/)
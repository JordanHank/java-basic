# Hashtable 类

HashTable 是 Dictionary的实现类，又实现了Map 接口，是存储键值对的散列表。
HashTable 的函数都是同步的，这意味着它是线程安全的，它的key、value都不可以为null。

## 构造函数

Hashtable 的四种构造函数：

+ 默认无参构造函数，用默认的初始容量 (11) 和加载因子 (0.75) 构造一个新的空哈希表。
``` java
Hashtable()
```

+ 指定初始大小的构造函数，用指定初始容量和默认的加载因子 (0.75) 构造一个新的空哈希表。
``` java
Hashtable(int initialCapacity)
```

+ 指定大小和扩充因子，用指定初始容量和指定加载因子构造一个新的空哈希表。
``` java
Hashtable(int initialCapacity, float loadFactor) 
```

+ 构造一个与给定的 Map 具有相同映射关系的新哈希表，为初始化元素，容量被设置为 Map 的两倍。
``` java
Hashtable(Map<? extends K,? extends V> t) 
```

!>**注意：** 扩充因子必须介于0.0和1.0之间，它决定了哈希表在重新调整大小之前的充满程度。

## 常用方法

|方法名  |  作用描述|
|---| ---|
|void clear() | 将此哈希表清空，使其不包含任何键|
|Object clone() | 创建此哈希表的浅表副本|
|boolean contains(Object value) | 测试此映射表中是否存在与指定值关联的键|
|boolean containsKey(Object key) | 测试指定对象是否为此哈希表中的键|
|boolean containsValue(Object value) | 如果此 Hashtable 将一个或多个键映射到此值，则返回 true|
|Enumeration<V> elements() | 返回此哈希表中的值的枚举|
|Set<Map.Entry<K,V>> entrySet()| 返回此映射中包含的键的 Set 视图|
|boolean equals(Object o)| 按照 Map 接口的定义，比较指定 Object 与此 Map 是否相等|
|V get(Object key) | 返回指定键所映射到的值，如果此映射不包含此键的映射，则返回 null. 更确切地讲，如果此映射包含满足 (key.equals(k)) 的从键 k 到值 v 的映射，则此方法返回 v；否则，返回 null|
|int hashCode() | 按照 Map 接口的定义，返回此 Map 的哈希码值|
|boolean isEmpty()| 测试此哈希表是否没有键映射到值|
|Enumeration<K> keys()| 返回此哈希表中的键的枚举|
|Set<K> keySet()| 返回此映射中包含的键的 Set 视图|
|V put(K key, V value)| 将指定 key 映射到此哈希表中的指定 value|
|void putAll(Map<? extends K,? extends V> t) | 将指定映射的所有映射关系复制到此哈希表中，这些映射关系将替换此哈希表拥有的、针对当前指定映射中所有键的所有映射关系|
|protected  void rehash() | 增加此哈希表的容量并在内部对其进行重组，以便更有效地容纳和访问其元素|
|V remove(Object key) | 从哈希表中移除该键及其相应的值|
|int size()| 返回此哈希表中的键的数量|
|String toString()| 返回此 Hashtable 对象的字符串表示形式，其形式为 ASCII 字符 ", " （逗号加空格）分隔开的、括在括号中的一组条目|
|Collection<V> values() | 返回此映射中包含的键的 Collection 视图|

## 遍历

Hashtable 可以使用的遍历方法有以下三种：

+ 通过迭代器Iterator，迭代获取Hashtable 类实例的entrySet()。

``` java
Hashtable<String, String> sports = new Hashtable<>();

sports.put("basketball", "favorite");
sports.put("football", "a little");
sports.put("swim", "can't");

Iterator<Map.Entry<String, String>> iter = sports.entrySet().iterator();
while(iter.hasNext()){
    Map.Entry<String, String> entry = iter.next();
    String key = entry.getKey();
    String value = entry.getValue();
    System.out.println("entrySet(key: " + key+" | value: " + value + ")");
}
``` 

+ 通过迭代器Iterator，迭代获取Hashtable 类实例的keySet()。

``` java
Hashtable<String, String> sports = new Hashtable<>();

sports.put("basketball", "favorite");
sports.put("football", "a little");
sports.put("swim", "can't");

Iterator<String> iterator = sports.keySet().iterator();
while(iterator.hasNext()){
    String key = iterator.next();
    //获取对应键的值
    String value = sports.get(key);
    System.out.println("key: " + key+" | value: " + value);
}
``` 

+ 通过keys()返回Hashtable 类实例的key键集合，通过遍历键值遍历。

``` java
Hashtable<String, String> sports = new Hashtable<>();

sports.put("basketball", "favorite");
sports.put("football", "a little");
sports.put("swim", "can't");

Enumeration<String> keys = sports.keys();
while (keys.hasMoreElements()) {
    String key = keys.nextElement();
    String value = sports.get(key);
    System.out.println("key: " + key+" | value: " + value);
}
``` 

## 示例

``` java
public class HashTableIntro {

    public static void main(String [] args) {

        //创建初始化
        Hashtable<String, String> sports = new Hashtable<>();

        //添加元素
        sports.put("basketball", "favorite");
        sports.put("football", "a little");
        sports.put("swim", "can't");

        Enumeration<String> keys = sports.keys();
        System.out.println("HashTable sports 的 keys: ");
        while (keys.hasMoreElements()) {
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();

        Enumeration<String> values = sports.elements();
        System.out.println("HashTable sports 的 values: ");
        while (values.hasMoreElements()) {
            System.out.print(values.nextElement() + " ");
        }

        //遍历HashTable 的三种方法
        System.out.println("第一种==========");
        Iterator<Map.Entry<String, String>> iter = sports.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("entrySet(key: " + key+" | value: " + value + ")");
        }
        System.out.println();

        System.out.println("第二种===========");
        Iterator<String> iterator = sports.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            //获取对应键的值
            String value = sports.get(key);
            System.out.println("key: " + key+" | value: " + value);
        }
        System.out.println();

        System.out.println("第三种==================");
        //由于上面的while (keys.hasMoreElements())已经把所有keys都遍历完了所以必须重新赋值
        keys = sports.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = sports.get(key);
            System.out.println("key: " + key+" | value: " + value);
        }
        System.out.println();

        //判断是否含有指定值得键
        boolean existKey = sports.contains("a little");
        System.out.println("sports中对应值a little得键存在：" + existKey);
        //也可以用下面的方法判断
        existKey = sports.containsValue("can");
        System.out.println("sports中对应值can 得键存在：" + existKey);
        System.out.println();

        //判断是否包含对应的键
        boolean containsKey = sports.containsKey("baseball");
        System.out.println("sports中包含键baseball: " + containsKey);
        System.out.println();

        //获取HashTable的大小
        int size = sports.size();
        System.out.println("sports 的大小为：" + size);
        System.out.println();

        //清空HashTable 使其不包含任何键
        sports.clear();

        //判断HashTable 是否为空
        if (sports.isEmpty()) {
            System.out.println("sports被清空了");
        }
    }
}
```
# HashMap 类

HashMap 是一个散列表，用于储存键值对。HashMap 继承于AbstractMap，实现了Map、Cloneable、java.io.Serializable接口，可以被克隆，支持序列化，能通过序列化去传输。
HashMap 不是线程同步的，储存的键值对可以是null，但只能有一个键为null。

HashMap 中两个影响性能的参数是：初始容量initialCapacity 和扩充因子loadFactor。

+  初始容量initialCapacity指定哈希表在创建时的容量。

+  扩充因子loadFactor用于计算哈希表扩充时的条件（哈希表中的条目数超出了扩充因子与当前容量的乘积时），扩充因子的默认值为0.75。

## 构造函数

HashMap 的构造函数有以下四种：

+ 默认无参构造函数，构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。

``` java
HashMap() 
```

+ 指定初始哈希表容量，构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。

``` java
HashMap(int initialCapacity)
```

+ 指定初始容量和扩充因子， 构造一个带指定初始容量和加载因子的空 HashMap。

``` java
HashMap(int initialCapacity, float loadFactor) 
```

+ 指定Map集合，构造一个映射关系与指定 Map 相同的新 HashMap。

``` java
HashMap(Map<? extends K,? extends V> m) 
```

## 成员变量

HashMap的成员变量：

+ table是一个Entry[]数组类型，而Entry实际上就是一个单向链表用于存储键值对。

+ size是HashMap的大小，实际是存储的键值对的数量。

+ threshold扩充阈值，用于判断HashMap是否需要扩充，threshold的值="容量*加载因子"，达到阈值扩充时HashMap容量加倍。

+ loadFactor就是扩充因子，用于计算扩充阈值。

+ modCount用于计算快速失败机制。

## 常用方法

|方法名  |  作用描述|
|---| ---|
|void clear()| 从此映射中移除所有映射关系|
|Object clone()|  返回此 HashMap 实例的浅表副本：并不复制键和值本身 |
|boolean containsKey(Object key) | 如果此映射包含对于指定键的映射关系，则返回 true |
|boolean containsValue(Object value) | 如果此映射将一个或多个键映射到指定值，则返回 true |
|Set<Map.Entry<K,V>> entrySet() | 返回此映射所包含的映射关系的 Set 视图|
|V 	get(Object key) | 返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null|
|boolean isEmpty() | 如果此映射不包含键-值映射关系，则返回 true|
|Set<K>	 keySet()| 返回此映射中所包含的键的 Set 视图|
|V	put(K key, V value)| 在此映射中关联指定值与指定键|
|void putAll(Map<? extends K,? extends V> m) | 将指定映射的所有映射关系复制到此映射中，这些映射关系将替换此映射目前针对指定映射中所有键的所有映射关系|
|V remove(Object key) | 从此映射中移除指定键的映射关系（如果存在） |
|int size() | 返回此映射中的键-值映射关系数|
|Collection<V> 	values() | 返回此映射所包含的值的 Collection 视图 |

## 示例

``` java
public class Demo {

    public static void main(String [] args) {
        //创建初始化
        HashMap hashMap = new HashMap();

        //添加元素
        hashMap.put("name", "Jordan Zhang");
        hashMap.put("gender", "man");
        hashMap.put("hobby", "sports");

        //获取元素
        String name = (String) hashMap.get("name");
        System.out.println("name为：" + name);
        System.out.println();

        //克隆HashMap
        HashMap clone = (HashMap) hashMap.clone();

        //允许键值对为空
        hashMap.put(null, null);
        System.out.println("key 为null 时value为 " + hashMap.get(null));
        System.out.println();

        //只允许有一个键为null,再次添加元素只会覆盖value
        hashMap.put(null, "new value");
        System.out.println("再次添加元素后key 为null 时value为 " + hashMap.get(null));
        System.out.println();

        //判断是否包含键key
        boolean containsKey = hashMap.containsKey("gender");
        if (containsKey) {
            System.out.println("hashMap中包含键gender");
        } else {
            System.out.println("hashMap中不包含键gender");
        }
        System.out.println();

        //判断是否包含值value
        boolean containsValue = hashMap.containsValue(1243);
        if (containsValue) {
            System.out.println("hashMap中包含值1243");
        } else {
            System.out.println("hashMap中不包含值1243");
        }
        System.out.println();

        //获取HashMap的大小
        int size = hashMap.size();
        System.out.println("hashMap的容量为：" + size);
        System.out.println();

        //通过键移除键值对
        Object ret = hashMap.remove("name");
        System.out.println("移除hashMap中的键为name的键值对返回：" + ret);
        System.out.println("查询hashMap中键为name返回：" + hashMap.get("name"));
        System.out.println();

        //通过键值对移除
        boolean remove = hashMap.remove("gender", "man");
        System.out.println("移除hashMap中的键值对gender-man返回：" + remove);
        System.out.println();

        //清空HashMap
        hashMap.clear();

        //判断HashMap是否为空
        if (hashMap.isEmpty()) {
            System.out.println("hashMap容量为空");
        } else {
            System.out.println("hashMap容量不为空");
        }
        System.out.println();

        System.out.println("HashMap的遍历方法：");
        //迭代器遍历键值对
        System.out.println("迭代器遍历键值对");
        Iterator iterator = clone.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            // 获取key
            String key = (String)entry.getKey();
            // 获取value
            String value = (String)entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过遍历键遍历 无法获取键key
        System.out.println("通过遍历键遍历");
        iterator = clone.keySet().iterator();
        while (iterator.hasNext()) {
            // 获取key
            String key = (String)iterator.next();
            // 获取value
            String value = (String)clone.get(key);
            System.out.println("key: " + key + " value: " + value);
        }
        System.out.println();

        //通过遍历值遍历
        System.out.println("通过遍历值遍历");
        Collection collection = clone.values();
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}
```
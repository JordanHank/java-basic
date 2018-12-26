# Dictionary 类

Dictionary 类是任何可将键映射到相应值的类（如 Hashtable）的抽象父类，作用和Map类相似。
Dictionary是一个抽象类,它的所有方法都是抽象的,这些性质导致它更像一个interface(接口).但是这个类出现时还不存在接口的概念。
Dictionary已经过时，新的实现应该实现 Map 接口，而不是扩展此类。

## 构造函数

Dictionary 类只有一个无参的构造函数。
``` java
Dictionary() 
```

!>**注意：** 因为Dictionary只是一个抽象类，所以使用只能通过它的子类。

## 常用方法

|方法名  |  作用描述|
|---| ---|
|abstract  Enumeration<V> elements() | 返回此 dictionary 中值的枚举|
|abstract  V get(Object key)| 返回此 dictionary 中该键所映射到的值|
|abstract  boolean isEmpty()| 测试此 dictionary 是否不存在从键到值的映射|
|abstract  Enumeration<K> keys()| 返回此 dictionary 中的键的枚举|
|abstract  V put(K key, V value) | 将指定 key 映射到此 dictionary 中指定 value|
|abstract  V remove(Object key) | 从此 dictionary 中移除 key （及其相应的 value）|
|abstract  int size() | 返回此 dictionary 中条目（不同键）的数量 |

## 示例

``` java
public class Demo {

    public static void main(String [] args) {

        //Hashtable是Dictionary的子类
        Dictionary<String, String> dictionary = new Hashtable<>();

        //向字典中添加键值对
        Object object = dictionary.put("key", "value");
        System.out.println("put key return: " + object);
        System.out.println();

        for (int i = 1; i < 5; i++) {
            dictionary.put("key" + i, "value" + i);
        }

        //键和值都不能为null 不然抛出NullPointerException
        //dictionary.put(null, null);
        //dictionary.put("null", null);

        //判断字典是否为空
        boolean isEmpty = dictionary.isEmpty();
        System.out.println("dictionary is empty: " + isEmpty);
        System.out.println();

        //获取字典中的条目数
        int size = dictionary.size();
        System.out.println("dictionary size is " + size);
        System.out.println();

        //删除指定键的元素
        Object value = dictionary.remove("key");
        System.out.println("remove key return: " + value);
        System.out.println();

        //返回键的枚举
        Enumeration keys = dictionary.keys();
        //键名枚举不为空
        System.out.println("dictionary keys: ");
        while (keys.hasMoreElements()) {
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();

        //返回值得枚举
        Enumeration values = dictionary.elements();
        System.out.println("dictionary values: ");
        while (values.hasMoreElements()) {
            System.out.print(values.nextElement() + " ");
        }
    }
}
``` 
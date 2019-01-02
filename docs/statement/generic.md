# 泛型

Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型检查机制，允许程序员在编译时检测到非法的类型。

## 泛型方法

泛型应用在方法上时我们称之为泛型方法，泛型方法在调用时，可以接收不同类型的参数，根据传递的参数，编译器会适当地处理。

泛型方法规则：

+ 所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前。

+ 每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。

+ 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。

+ 类型参数只能代表引用型类型，不能是原始类型。

+ 有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。

#### 示例

``` java
// 泛型方法 addToList  E为类型参数
public static <E>List addToList(List<E> list, E element) {
    list.add(element);
    return list;
}

//类型参数上限为Number
public static <E extends Number> void printList(List<E> list) {
    for (E element: list) {
        System.out.print(element + " ");
    }
    System.out.println();
}
```

## 泛型类

泛型应用于类时对应的类我们称之为泛型类，泛型类和非泛型类唯一的区别在于泛型类在类名后面添加了类型参数声明部分，而非泛型类没有。

泛型类应用的规则：

+  泛型类的类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。

#### 示例

``` java
class Box<T> {

    private List list;

    public void add(T t) {
        if (list == null) {
            list = new ArrayList();
        }
        this.list.add(t);
    }

    //通配符
    public List<? extends Comparable> getList() {
        return this.list;
    }
}
```

## 类型通配符

+ 类型通配符一般是使用?代替具体的类型参数，例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。

+ <? extends T>表示该通配符所代表的类型是T类型的子类。

+ <? super T>表示该通配符所代表的类型是T类型的父类。

#### 示例

``` java
public class Demo {

    public static void main(String [] args) {

    List<String> stringList = new ArrayList<>();
    stringList = addToList(stringList, "test");
    stringList = addToList(stringList, "string");
    stringList = addToList(stringList, "array");
//        printList(stringList);  //报错无法编译通过因为类型参数的上限位Number

    List<Integer> integerList = new ArrayList<>();
    integerList = addToList(integerList,11);
    integerList = addToList(integerList,131);
    integerList = addToList(integerList,567);
    printList(integerList);

    Box<Integer> integerBox = new Box<>();
    integerBox.add(23);
    integerBox.add(45);
    integerBox.add(67);

    printList((List<Integer>) integerBox.getList());

    Box<Float> floatBox = new Box<>();
    floatBox.add((float) 1.123);
    floatBox.add((float) 43.23);
    floatBox.add((float) 76.12);

    printList((List<Float>) floatBox.getList());

    Box<String> stringBox = new Box<>();
    stringBox.add("name");
    stringBox.add("age");
    stringBox.add("gender");
    stringList = (List<String>) stringBox.getList();
    for (String str: stringList) {
        System.out.print(str + " ");
    }

    // 泛型方法 addToList  E为类型参数
    public static <E>List addToList(List<E> list, E element) {
        list.add(element);
        return list;
    }

    //类型参数上限为Number
    public static <E extends Number> void printList(List<E> list) {
        for (E element: list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

//泛型类
class Box<T> {

    private List list;

    public void add(T t) {
        if (list == null) {
            list = new ArrayList();
        }
        this.list.add(t);
    }

    //通配符
    public List<? extends Comparable> getList() {
        return this.list;
    }
}
```

## 使用

对于泛型，只是允许程序员在编译时检测到非法的类型而已，但是在运行期时，其中的泛型标志会变化为 Object 类型，所以无法再编译期避免泛型类的类型检查问题，但是可以在运行期通过反射操作跳过类型检查。

####示例

``` java
List<Integer> list = new ArrayList<>();

list.add(12);
//这里直接添加会报错
//        list.add("a");
Class<? extends List> clazz = list.getClass();
Method add = null;
try {
    add = clazz.getDeclaredMethod("add", Object.class);
} catch (NoSuchMethodException e) {
    e.printStackTrace();
}
//但是通过反射添加，是可以的
try {
    add.invoke(list, "kl");
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
```
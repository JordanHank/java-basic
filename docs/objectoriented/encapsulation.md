# 封装

在面向对象编程思想中，封装指的是一种将抽象性函式接口的实现细节部份包装、隐藏起来的方法。通俗一点的说，封装就是将事物
本身的属性或者行为隐藏起来，通过统一的一种许可的方式来获取隐藏的信息。比如生活中，女生一般将自己的年龄作为秘密，你直接询问
无法获得她们的年龄，这时候如果是警察叔叔调查询问的话，她们就会照实说出自己的年纪了。这里女生是封装的事物，年龄是隐藏的属性，
而警察叔叔调查是统一接口。

## 步骤

封装的步骤主要是两步：

+ 隐藏：降低成员属性、方法的可见性（一般是设置为private)，使得对象实例外部无法获取成员属性、方法，从而隐藏细节。

+ 获取：提供统一的公共方法访问修改后的私有属性、方法（一般是设置set/get方法）。

``` java
class Person {

    //私有属性姓名
    private String name;

    //设置姓名的公共方法
    public String getName() {
        return name;
    }

    //获取姓名的公共方法
    public void setName(String name) {
        this.name = name;
    }

    //私有方法
    private String complain(String who) {
        return who + "is a bad guy";
    }
    
    //获取私有方法的结果
    public String getComplainResult(String who) {
        return this.complain(who);
    }
}
```


## 优点

封装可以认为是一种防护屏障，防止该类的代码和数据被外部类定义的代码随机访问。对类进行封装后，只能通过严格的接口访问私有数据，这样提高了代码的安全性，同时降低了代码耦合。

+ 良好的封装能够减少耦合。

+ 类内部的结构可以自由修改。

+ 以对成员变量进行更精确的控制。

+ 隐藏信息，实现细节。

## 示例

下面示例展示了类的封装以及使用：
``` java
public class Demo {

    public static void main(String [] args) {

        Student a = new Student("132444313123", "张三", 21);
        System.out.println(a);
        System.out.println("=======");

        //通过set方法修改私有属性name
        a.setName("李四");
        //通过get方法获取私有属性name
        String name = a.getName();
        System.out.println(name);
    }
}


class Student {

    //私有属性限制访问
    private String id;

    private String name;

    private int age;

    //构造函数
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //通过set/get方法访问私有属性
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "学生：" + this.name + ", " + this.age + "岁， " + "学号为： " + this.id;
    }
}
```
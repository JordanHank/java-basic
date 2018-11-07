package com.blackj.leran.java.statement;

import java.io.*;

/**
 * Program Name: java-basic
 * <p>
 * Description: java 序列化声明
 * <p>
 * Created by Zhang.Haixin on 2018/11/7
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class SerializeStatement {

    /**
     * java 提供对象序列化机制，序列化后一个对象可以被表示为一个字节序列，
     * 该字节序列包括该对象的数据、有关对象的类型的信息和存储在对象中数据的类型
     *
     * 序列化对象可以写入文件进行数据持久化，同时也可以对持久化后的对象进行反序列化在内存中新建对象使用
     * 对可序列化对象使用类 ObjectInputStream 和 ObjectOutputStream 序列化和反序列化
     * ObjectOutputStream 类的序列化方法：
     *      public final void writeObject(Object x) throws IOException
     *
     * ObjectInputStream 类的序列化方法：
     *      public final Object readObject() throws IOException, ClassNotFoundException
     *
     * 对象实现序列化和反序列化的条件：
     *      必须实现java.io.Serializable 接口
     *      所有属性必须是可序列化的（属性类型也实现了java.io.Serializable 接口），否则必须用transient关键字声明属性不可序列化
     */
    public static void main(String [] args) {

        Person me = new Person("Jordan Zhang", 26, "man");
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream("person.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(me);
            out.close();
            fileOut.close();
            System.out.println("Person 对象 me 序列化之后保存在：person.ser");
        } catch(IOException i) {
            i.printStackTrace();
            System.out.println("序列化对象发生IO异常");
        } finally {
            //关闭资源
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭对象输出流发生IO异常");
                }
            }
            if (null != fileOut) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭文件输出流发生IO异常");
                }
            }
        }

        Person readMe = null;

        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream("person.ser");
            in = new ObjectInputStream(fileIn);
            readMe = (Person) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("反序列化对象发生IO异常");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("反序列化对象没有找到对应的类信息");
        } finally{
            //关闭资源
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭对象输入流发生IO异常");
                }
            }
            if (null != fileIn) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭文件输入流发生IO异常");
                }
            }
        }
        if (null != readMe) {
            //输出结果age=0 是因为age属性没有进行序列化 所以反序列化的时候为int类型初始值0
            System.out.println(readMe);
        }
    }
}


class Person implements Serializable {

    private String name;

    //关键字transient 修饰age属性，表示age属性不进行序列化
    private transient int age;

    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
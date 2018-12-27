# Properties 类

Properties 继承于 HashTable，表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串，可以用来获取.properties后缀的配置文件。
此类是线程安全的：多个线程可以共享单个 Properties 对象而无需进行外部同步。

## 构造函数

+ 默认无参的构造函数，创建一个无默认值的空属性列表。

``` java
Properties() 
```

+ 指定配置文件的构造函数，创建一个带有指定默认值的空属性列表。

``` java
Properties(Properties defaults)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|String getProperty(String key) | 用指定的键在此属性列表中搜索属性|
|String getProperty(String key, String defaultValue) | 用指定的键在属性列表中搜索属性|
|void list(PrintStream out) | 将属性列表输出到指定的输出流|
|void list(PrintWriter out) |  将属性列表输出到指定的输出流|
|void load(InputStream inStream) | 从输入流中读取属性列表（键和元素对）|
|void load(Reader reader) | 按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）|
|void loadFromXML(InputStream in) | 将指定输入流中由 XML 文档所表示的所有属性加载到此属性表中|
|Enumeration<?> propertyNames() | 返回属性列表中所有键的枚举，如果在主属性列表中未找到同名的键，则包括默认属性列表中不同的键|
|Object setProperty(String key, String value) | 调用 Hashtable 的方法 put|
|void store(OutputStream out, String comments) |  以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流|
|void store(Writer writer, String comments)| 以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符|
|void storeToXML(OutputStream os, String comment) | 发出一个表示此表中包含的所有属性的 XML 文档|
|void storeToXML(OutputStream os, String comment, String encoding) | 使用指定的编码发出一个表示此表中包含的所有属性的 XML 文档|
|Set<String> stringPropertyNames() | 返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键|

## 示例

``` java
public class Demo {

    public static void main(String [] args) {

        //创建初始化
        Properties dataBase = new Properties();

        //添加配置项 底层是调用的HashTable的put()方法
        dataBase.setProperty("driver", "com.mysql.jdbc.Driver");
        dataBase.setProperty("url", "jdbc:mysql///user");
        dataBase.setProperty("user", "root");
        dataBase.setProperty("password", "451535");

        //读取配置
        String mysql = dataBase.getProperty("user");
        System.out.println(mysql);
        System.out.println();

        InputStream inputStream = null;
        FileOutputStream outputFile = null;
        OutputStreamWriter osw = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("test.properties"));
            //读取配置文件
            Properties test = new Properties();
            test.load(inputStream);

            Set keyValue = test.keySet();
            for (Iterator it = keyValue.iterator(); it.hasNext();) {
                String key = (String) it.next();
                System.out.println(key + ": " + test.getProperty(key));
            }

            //将配置写入到文件中
            outputFile = new FileOutputStream("test.properties");
            //设置编码格式，防止乱码
            osw = new OutputStreamWriter(outputFile, "utf-8");
            dataBase.store(osw, "配置写入文件测试");
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
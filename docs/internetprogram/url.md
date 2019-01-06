# URL

URL（Uniform Resource Locator）为统一资源定位符，也就是网页地址，表示为互联网上的资源，如网页或者FTP地址。

## 组成

URL组成：protocol://host:port/path?query#fragment

+ protocol：网络协议，可以是 HTTP、HTTPS、FTP 和 File。

+ host：主机地址。

+ port：端口号。

+ path：请求路径。

+ query：请求参数。

+ fragment: j2se，定位到网页中 id 属性为 j2se 的 HTML 元素位置。

## 构造函数

URL类在java.net包中，构造函数：

+ 指定协议，主机地址，端口号和文件的构造函数。

``` java
public URL(String protocol, String host, int port, String file) throws MalformedURLException
```

+ 指定协议，主机地址和文件的构造函数。

``` java
public URL(String protocol, String host, String file) throws MalformedURLException
```

+ 通过指定的url地址创建。

``` java
public URL(String url) throws MalformedURLException
```

+ 使用基地址和相对URL创建。

``` java
public URL(URL context, String url) throws MalformedURLException
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|boolean equals(Object obj) | 比较此 URL 是否等于另一个对|
|String	getAuthority() | 获取此 URL 的授权部分|
|Object getContent() | 获取此 URL 的内容 |
|Object	getContent(Class[] classes) | 获取此 URL 的内容 |
|int getDefaultPort() | 获取与此 URL 关联协议的默认端口号 |
|String getFile() | 获取此 URL 的文件名 |
|String getHost() | 获取此 URL 的主机名（如果适用） |
|String getPath() | 获取此 URL 的路径部分 |
|int getPort() | 获取此 URL 的端口号 |
|String getProtocol() | 获取此 URL 的协议名称 |
|String getQuery() | 获取此 URL 的查询部分 |
|String getRef() | 获取此 URL 的锚点（也称为“引用”） |
|String getUserInfo() | 获取此 URL 的 userInfo 部分 |
|int hashCode() | 创建一个适合哈希表索引的整数 |
|URLConnection openConnection() | 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接 |
|URLConnection openConnection(Proxy proxy) | 与 openConnection() 类似，所不同是连接通过指定的代理建立；不支持代理方式的协议处理程序将忽略该代理参数并建立正常的连接 |
|InputStream openStream() | 打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream｜
|boolean sameFile(URL other) | 比较两个 URL，不包括片段部分｜
|protected  void set(String protocol, String host, int port, String file, String ref) | 设置 URL 的字段｜
|protected  void set(String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref)  | 设置 URL 的指定的 8 个字段｜
|static void setURLStreamHandlerFactory(URLStreamHandlerFactory fac) | 设置应用程序的 URLStreamHandlerFactory|
|String toExternalForm() | 构造此 URL 的字符串表示形式|
|String toString() | 构造此 URL 的字符串表示形式|
|URI toURI() | 返回与此 URL 等效的 URI|

## 示例

``` java
public class Demo {

    public static void main(String[] args) {

        BufferedReader in = null;
        try {
            //百度搜索java结果地址
            String urlPath = "https://www.baidu.com/s?ie=utf-8" +
                    "&f=8&rsv_bp=1&rsv_idx=2&tn=62095104_10_oem_dg&wd=java" +
                    "&rsv_spt=1&oq=jquery&rsv_pq" +
                    "=a3fa28f100000dda&rsv_t=2d1aqowxY1tQOMKbrNbydmTe1doTSy3aLWyzYSvLLhC5" +
                    "%2BnDdWVkBRMpyyh85odjmPEuwTqUL%2Fx2U&rqlang=cn&rsv_enter=0" +
                    "&rsv_sug3=4&rsv_sug1=1&rsv_sug7=100" +
                    "&inputT=2381&rsv_sug4=2381&rsv_sug=2";
            //指定访问路径创建
            URL url = new URL(urlPath);

            System.out.println("URL 为：" + url.toString());

            System.out.println("协议为：" + url.getProtocol());

            System.out.println("验证信息：" + url.getAuthority());

            System.out.println("文件名及请求参数：" + url.getFile());

            System.out.println("主机名：" + url.getHost());

            System.out.println("路径：" + url.getPath());

            System.out.println("端口：" + url.getPort());

            System.out.println("默认端口：" + url.getDefaultPort());

            System.out.println("请求参数：" + url.getQuery());

            System.out.println("定位位置：" + url.getRef());

            /**
             * openConnection() 返回一个 java.net.URLConnection
             * HTTP协议的URL, openConnection() 方法返回 HttpURLConnection 对象
             * HTTPS协议的URL, openConnection() 方法返回 HttpsURLConnection 对象
             * URL为一个 JAR 文件, openConnection() 方法将返回 JarURLConnection 对象
             * ...等等
             */
            URLConnection urlConnection = url.openConnection();
            if(urlConnection instanceof HttpURLConnection) {
                urlConnection = (HttpURLConnection) urlConnection;
            } else if(urlConnection instanceof HttpsURLConnection) {
                urlConnection = (HttpsURLConnection) urlConnection;
            } else if(urlConnection instanceof JarURLConnection) {
                urlConnection = (JarURLConnection) urlConnection;
            } else {
                System.out.println(url + "不是一个有效地址");
                return;
            }

            //getInputStream() 返回URL的输入流，用于读取资源
            in = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            //读取网址内容
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            System.out.println(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```
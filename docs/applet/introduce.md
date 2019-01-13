# Applet

Applet一般是运行在支持 Java 的 Web 浏览器内Java 小程序。

## 与Java 应用区别

独立的 Java 应用程序和 applet 程序之间重要的不同有下面几点：

+ Java 中 Applet 类继承了 java.applet.Applet 类。

+ Applet 类没有定义 main()，所以一个 Applet 程序不会调用 main() 方法。

+ Applet 被设计为嵌入在一个 HTML 页面。

+ 当用户浏览包含 Applet 的 HTML 页面，Applet 的代码就被下载到用户的机器上。

+ 要查看一个 Applet 需要 JVM。 JVM 可以是 Web 浏览器的一个插件，或一个独立的运行时环境。

+ 用户机器上的 JVM 创建一个 Applet 类的实例，并调用 Applet 生命周期过程中的各种方法。

+ Applet 有 Web 浏览器强制执行的严格的安全规则，Applet 的安全机制被称为沙箱安全。

+ Applet 需要的其他类可以用 Java 归档（JAR）文件的形式下载下来。

## 运行条件

Applet运行的条件：

+ 没有main()函数。

+  必须嵌套在HTML中。

+ 必须有JVM运行环境。

## 生命周期

Applet的生命周期：

+ `init: `该方法的目的是为你的 Applet 提供所需的任何初始化。在 Applet 标记内的 param 标签被处理后调用该方法。

+ `start: `浏览器调用`init() `方法后，该方法被自动调用。每当用户从其他页面返回到包含 Applet 的页面时，则调用该方法。

+ `stop: `当用户从包含 Applet 的页面移除的时候，该方法自动被调用。因此，可以在相同的 Applet 中反复调用该方法。

+ `destroy: `此方法仅当浏览器正常关闭时调用。因为 Applet 只有在 HTML 网页上有效，所以你不应该在用户离开包含 Applet 的页面后遗漏任何资源。

+ `paint: `该方法在`start() `方法之后立即被调用，或者在 Applet 需要重绘在浏览器的时候调用。`paint() `方法实际上继承于 java.awt。

## Applet 类

Applet 类必须是任何嵌入 Web 页或可用 Java Applet Viewer 查看的 applet 的超类。Applet 类提供了 applet 及其运行环境之间的标准接口。

#### 构造函数

无参构造函数，构造一个新 Applet。

``` java
Applet()
```

#### 方法列表

|方法名  |  作用描述|
|---| ---|
|void destroy() | 由浏览器或 applet viewer 调用，通知此 applet 它正在被回收，它应该销毁分配给它的任何资源|
|AccessibleContext getAccessibleContext() | 获取与此 Applet 关联的 AccessibleContext |
|AppletContext getAppletContext() | 确定此 applet 的上下文，上下文允许 applet 查询和影响它所运行的环境|
|String getAppletInfo() | 返回有关此 applet 的信息 |
|AudioClip getAudioClip(URL url) |  返回 URL 参数指定的 AudioClip 对象 |
|AudioClip getAudioClip(URL url, String name) | 返回 URL 和 name 参数指定的 AudioClip 对象|
|URL getCodeBase() | 获得基 URL |
|URL getDocumentBase() | 获取嵌入此 applet 的文档的 URL|
|Image getImage(URL url) | 返回能被绘制到屏幕上的 Image 对象|
|Image 	getImage(URL url, String name)| 返回能被绘制到屏幕上的 Image 对象|
|Locale getLocale() | 获取 applet 的语言环境 |
|String getParameter(String name)| 返回 HTML 标记中指定参数的值|
|String[][] getParameterInfo() | 返回此 applet 理解的关于参数的信息|
|void init() | 由浏览器或 applet viewer 调用，通知此 applet 它已经被加载到系统中|
|boolean isActive()| 确定 applet 是否处于活动状态|
|static AudioClip newAudioClip(URL url) | 从给定 URL 处获取音频剪辑|
|void play(URL url) | 播放指定绝对 URL 处的音频剪辑|
|void play(URL url, String name) | 播放音频剪辑，给定了 URL 及与之相对的说明符|
|void resize(Dimension d) | 请求调整此 applet 的大小|
|void resize(int width, int height) | 请求调整此 applet 的大小|
|void setStub(AppletStub stub)| 设置此 applet 的 stub|
|void showStatus(String msg) | 请求将参数字符串显示在“状态窗口”中|
|void start() | 由浏览器或 applet viewer 调用，通知此 applet 它应该开始执行|
|void stop()| 由浏览器或 applet viewer 调用，通知此 applet 它应该终止执行|


Applet 类从 Container 类继承了许多事件处理方法，为了响应一个事件，Applet 必须重写合适的事件处理方法。"Applet 能显示 GIF,JPEG,BMP 等其他格式的图片。为了在 Applet 中显示图片，你需要使用 java.awt.Graphics 类的drawImage()方法。

通过使用 java.applet 包中的 AudioClip 接口播放音频，常用方法：

+ `public void play():`从一开始播放音频片段一次。

+ `public void loop(): `循环播放音频片段。

+ `public void stop(): `停止播放音频片段。

## 获得applet参数

Applet必须嵌套在HTML中，所以<applet> 标签是在HTML文件中嵌入 Applet 的基础，指定参数必须使用<param>标签，Applet.getParameter() 方法通过给出参数名称得到参数值。如果得到的值是数字或者其他非字符数据，那么必须解析为字符串类型。

``` html
<html>
<title>Checkerboard Applet</title>
<hr>
<applet code="CheckerApplet.class" width="480" height="320">
<param name="color" value="blue">
<param name="squaresize" value="30">
</applet>
<hr>
</html>
```


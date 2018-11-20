package com.blackj.leran.java.applet;

/**
 * Program Name: java-basic
 * <p>
 * Description: java Applet介绍
 * <p>
 * Created by Zhang.Haixin on 2018/11/20
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class AppletIntro {

    /**
     * Applet一般是运行在支持 Java 的 Web 浏览器内java小程序
     * Applet运行的条件：
     *      没有main()方法
     *      必须嵌套在HTML中
     *      必须有JVM运行环境
     *
     * Applet的生命周期：
     *  init: 该方法的目的是为你的 Applet 提供所需的任何初始化。在 Applet 标记内的 param 标签被处理后调用该方法
     *  start: 浏览器调用 init 方法后，该方法被自动调用。每当用户从其他页面返回到包含 Applet 的页面时，则调用该方法
     *  stop: 当用户从包含 Applet 的页面移除的时候，该方法自动被调用。因此，可以在相同的 Applet 中反复调用该方法
     *  destroy: 此方法仅当浏览器正常关闭时调用。因为 Applet 只有在 HTML 网页上有效，所以你不应该在用户离开包含 Applet 的页面后遗漏任何资源
     *  paint: 该方法在 start() 方法之后立即被调用，或者在 Applet 需要重绘在浏览器的时候调用。paint() 方法实际上继承于 java.awt
     */
    public static void main(String [] args) {

        System.out.println("Applet必须嵌套在HTML中，所以<applet> 标签是在HTML文件中嵌入 Applet 的基础");
        System.out.println("指定参数必须使用<param>标签");
        System.out.println("Applet 类从 Container 类继承了许多事件处理方法,为了响应一个事件，Applet 必须重写合适的事件处理方法");
        System.out.println("Applet 能显示 GIF,JPEG,BMP 等其他格式的图片。为了在 Applet 中显示图片，你需要使用 java.awt.Graphics 类的drawImage()方法");
        System.out.println("通过使用 java.applet 包中的 AudioClip 接口播放音频");
        System.out.println("public void play(): 从一开始播放音频片段一次");
        System.out.println("public void loop(): 循环播放音频片段");
        System.out.println("public void stop(): 停止播放音频片段");
        System.out.println("java.security.AccessControlException: access denied (\"java.lang.RuntimePermission\" " +
                "\"modifyThreadGroup\")");
        System.out.println("需要到/Java/jre1.6.0/lib/security,在这个包下面有个java.policy文件修改grant");
    }
}

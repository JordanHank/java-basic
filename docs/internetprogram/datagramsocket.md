# DatagramSocket 类

DatagramSocket 类表示用来发送和接收数据报包的套接字。在 DatagramSocket 上总是启用 UDP 广播发送。为了接收广播包，应该将 DatagramSocket 绑定到通配符地址。在某些实现中，将 DatagramSocket 绑定到一个更加具体的地址时广播包也可以被接收。

## 构造函数

DatagramSocket 类有下面几种构造函数：

+ 构造数据报套接字并将其绑定到本地主机上任何可用的端口。

``` java
DatagramSocket()
```

+ 创建数据报套接字并将其绑定到本地主机上的指定端口。

``` java
DatagramSocket(int port)
```

+ 创建数据报套接字，将其绑定到指定的本地地址。

``` java
DatagramSocket(int port, InetAddress laddr)
```

+ 创建数据报套接字，将其绑定到指定的本地套接字地址。

``` java
DatagramSocket(SocketAddress bindaddr)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|void bind(SocketAddress addr) |  将此 DatagramSocket 绑定到特定的地址和端口|
|void close() | 关闭此数据报套接字 |
|void connect(InetAddress address, int port)  | 将套接字连接到此套接字的远程地址 |
|void connect(SocketAddress addr) | 将此套接字连接到远程套接字地址（IP 地址 + 端口号） |
|void disconnect() | 断开套接字的连接|
|boolean getBroadcast() | 检测是否启用了 SO_BROADCAST |
|DatagramChannel getChannel() | 返回与此数据报套接字关联的唯一 DatagramChannel 对象（如果有）|
|InetAddress getInetAddress() | 返回此套接字连接的地址 |
|InetAddress getLocalAddress() | 获取套接字绑定的本地地址 |
|int getLocalPort() | 返回此套接字绑定的本地主机上的端口号|
|SocketAddress	getLocalSocketAddress() | 返回此套接字绑定的端点的地址，如果尚未绑定则返回 null |
|int getPort() | 返回此套接字的端口 |
|int getReceiveBufferSize() | 获取此 DatagramSocket 的 SO_RCVBUF 选项的值，该值是平台在 DatagramSocket 上输入时使用的缓冲区大小|
|SocketAddress	getRemoteSocketAddress() | 返回此套接字连接的端点的地址，如果未连接则返回 null|
|boolean getReuseAddress() | 检测是否启用了 SO_REUSEADDR|
|int getSendBufferSize() | 获取此 DatagramSocket 的 SO_SNDBUF 选项的值，该值是平台在 DatagramSocket 上输出时使用的缓冲区大小 |
|int getSoTimeout() | 获取 SO_TIMEOUT 的设置|
|int getTrafficClass()| 为从此 DatagramSocket 上发送的包获取 IP 数据报头中的流量类别或服务类型|
|boolean isBound() |  返回套接字的绑定状态 |
|boolean isClosed() | 返回是否关闭了套接字|
|boolean isConnected() | 返回套接字的连接状态|
|void receive(DatagramPacket p) | 从此套接字接收数据报包 |
|void send(DatagramPacket p) | 从此套接字发送数据报包 |
|void setBroadcast(boolean on) | 启用/禁用 SO_BROADCAST |
|static void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) | 为应用程序设置数据报套接字实现工厂|
|void setReceiveBufferSize(int size) | 将此 DatagramSocket 的 SO_RCVBUF 选项设置为指定的值|
|void setReuseAddress(boolean on) | 启用/禁用 SO_REUSEADDR 套接字选项 |
|void setSendBufferSize(int size) | 将此 DatagramSocket 的 SO_SNDBUF 选项设置为指定的值 |
|void setSoTimeout(int timeout) | 启用/禁用带有指定超时值的 SO_TIMEOUT，以毫秒为单位 |
|void setTrafficClass(int tc) | 为从此 DatagramSocket 上发送的数据报在 IP 数据报头中设置流量类别 (traffic class) 或服务类型八位组 (type-of-service octet)|

## UDP 客户端示例

``` java
public class DatagramSocketClient {

    public static void main(String[] args) {

        //指定服务器接受端口
        int port = genPort(args);

        //指定包传输端口号
        int packetPort = genPacketPort(args);

        try {
            //指定端口创建 DatagramSocket 客户端
            DatagramSocket client = new DatagramSocket(packetPort);

            //指定UDP传输包大小
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            packet.setPort(port);
            //指定包传输地址为本地地址
            packet.setAddress(InetAddress.getLocalHost());

            String content = "你好服务端！";
            packet.setData(content.getBytes());

            //发送数据包
            client.send(packet);

            //客户端接受数据包
            client.receive(packet);

            System.out.println(packet.getAddress().getHostName() + "(" +
            packet.getPort() + "):" + new String(packet.getData()));

            //关闭客户端
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取初始化端口 默认为5060
    private static int genPort(String[] args) {
        if(args.length > 0) {
            try {
                return Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                return 5060;
            }
        } else {
            return 5060;
        }
    }

    //指定数据包传输端口
    private static int genPacketPort(String[] args) {
        if(args.length > 1) {
            try {
                return Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                return 5070;
            }
        } else {
            return 5070;
        }
    }
}
```
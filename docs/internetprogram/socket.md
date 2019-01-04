# Socket 类

java.net.Socket 类代表客户端和服务器都用来互相沟通的套接字。客户端要获取一个 Socket 对象通过实例化 ，而 服务器获得一个 Socket 对象则通过 accept() 方法的返回值。

## 构造函数

Socket 类有以下几种构造函数：

+ 通过系统默认类型的 SocketImpl 创建未连接套接字。

``` java
Socket()
```

+ 创建一个流套接字并将其连接到指定 IP 地址的指定端口号。

``` java
Socket(InetAddress address, int port)
```

+ 创建一个套接字并将其连接到指定远程地址上的指定远程端口。

``` java
Socket(InetAddress address, int port, InetAddress localAddr, int localPort)
```

+ 创建一个未连接的套接字并指定代理类型（如果有），该代理不管其他设置如何都应被使用。

``` java
Socket(Proxy proxy)
```

+ 创建一个流套接字并将其连接到指定主机上的指定端口号。

``` java
Socket(String host, int port)
```

+ 创建一个套接字并将其连接到指定远程主机上的指定远程端口。

``` java
Socket(String host, int port, InetAddress localAddr, int localPort)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|void bind(SocketAddress bindpoint) | 将套接字绑定到本地地址|
|void close()| 关闭此套接字 |
|void connect(SocketAddress endpoint)  | 将此套接字连接到服务器 |
|void connect(SocketAddress endpoint, int timeout) | 将此套接字连接到服务器，并指定一个超时值 |
|SocketChannel getChannel() | 返回与此数据报套接字关联的唯一 SocketChannel 对象（如果有）|
|InetAddress getInetAddress() | 返回套接字连接的地址 |
|InputStream getInputStream() | 返回此套接字的输入流 |
|boolean getKeepAlive() | 测试是否启用 SO_KEEPALIVE |
|InetAddress getLocalAddress() | 获取套接字绑定的本地地址 |
|int getLocalPort() | 返回此套接字绑定到的本地端口 |
|SocketAddress getLocalSocketAddress() | 返回此套接字绑定的端点的地址，如果尚未绑定则返回 null|
|boolean getOOBInline() | 测试是否启用 OOBINLINE |
|OutputStream getOutputStream() | 返回此套接字的输出流 |
|int getPort() | 返回此套接字连接到的远程端口 |
|int getReceiveBufferSize() | 获取此 Socket 的 SO_RCVBUF 选项的值，该值是平台在 Socket 上输入时使用的缓冲区大小|
|SocketAddress getRemoteSocketAddress() | 返回此套接字连接的端点的地址，如果未连接则返回 null|
|boolean getReuseAddress() | 测试是否启用 SO_REUSEADDR |
|int getSendBufferSize() | 获取此 Socket 的 SO_SNDBUF 选项的值，该值是平台在 Socket 上输出时使用的缓冲区大小|
|int getSoLinger() | 返回 SO_LINGER 的设置|
|int getSoTimeout() | 返回 SO_TIMEOUT 的设置|
|boolean getTcpNoDelay() | 测试是否启用 TCP_NODELAY|
|int getTcpNoDelay() | 测试是否启用 TCP_NODELAY |
|int getTrafficClass() | 为从此 Socket 上发送的包获取 IP 头中的流量类别或服务类型|
|boolean isBound() | 返回套接字的绑定状态|
|boolean isClosed() | 返回套接字的关闭状态|
|boolean isConnected() | 返回套接字的连接状态|
|boolean isInputShutdown() | 返回是否关闭套接字连接的半读状态 (read-half) |
|boolean isOutputShutdown() | 返回是否关闭套接字连接的半写状态 (write-half) |
|void sendUrgentData(int data) | 在套接字上发送一个紧急数据字节|
|void setKeepAlive(boolean on) | 启用/禁用 SO_KEEPALIVE |
|void setOOBInline(boolean on)  | 启用/禁用 OOBINLINE（TCP 紧急数据的接收者） 默认情况下，此选项是禁用的，即在套接字上接收的 TCP 紧急数据被静默丢弃|
|void setPerformancePreferences(int connectionTime, int latency, int bandwidth) | 设置此套接字的性能偏好|
|void setReceiveBufferSize(int size) | 将此 Socket 的 SO_RCVBUF 选项设置为指定的值 |
|void setReuseAddress(boolean on)  | 启用/禁用 SO_REUSEADDR 套接字选项 |
|void setSendBufferSize(int size) | 将此 Socket 的 SO_SNDBUF 选项设置为指定的值|
|static void setSocketImplFactory(SocketImplFactory fac) | 为应用程序设置客户端套接字实现工厂|
|void setSoLinger(boolean on, int linger) | 启用/禁用具有指定逗留时间（以秒为单位）的 SO_LINGER |
|void setSoTimeout(int timeout) | 启用/禁用带有指定超时值的 SO_TIMEOUT，以毫秒为单位|
|void setTcpNoDelay(boolean on) | 启用/禁用 TCP_NODELAY（启用/禁用 Nagle 算法）|
|void setTrafficClass(int tc) | 为从此 Socket 上发送的包在 IP 头中设置流量类别 (traffic class) 或服务类型八位组 (type-of-service octet)|
|void shutdownInput() | 此套接字的输入流置于“流的末尾”|
|void shutdownOutput() | 禁用此套接字的输出流 |
|String toString() | 将此套接字转换为 String |

## 客户端示例

``` java
public class SocketClient {

    public static void main(String[] args) {
        String host = null;
        int port = 0;

        //读取指定IP和端口号 没有默认使用本地地址和端口9999
        if(args.length > 2){
            host = args[0];
            port = Integer.parseInt(args[1]);
        }else{
            host = "127.0.0.1";
            port = 9999;
        }

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        Scanner s = new Scanner(System.in);
        try{
            //指定连接Socket
            socket = new Socket(host, port);
            String message = null;

            //初始化Socket 通信的输入流 默认编码UTF-8
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), "UTF-8"));

            //初始化Socket 通信输出流
            writer = new PrintWriter(
                    socket.getOutputStream(), true);

            //等待输入信息
            while(true){
                message = s.nextLine();
                if(message.equals("exit")){
                    break;
                }
                writer.println(message);
                writer.flush();
                System.out.println(reader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭Socket 通信
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            socket = null;

            //关闭输入流资源
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reader = null;

            //关闭输出流资源
            if(writer != null){
                writer.close();
            }
            writer = null;
        }
    }
}
```

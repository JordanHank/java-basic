# ServerSocket 类

服务器应用程序通过使用 java.net.ServerSocket 类以获取一个端口,并且侦听客户端请求。

## 构造函数

ServerSocket 类有下面几种构造函数：

+ 创建非绑定服务器套接字。

``` java
ServerSocket()
```

+ 创建绑定到特定端口的服务器套接字。

``` java
ServerSocket(int port)
```

+ 利用指定的 backlog 创建服务器套接字并将其绑定到指定的本地端口号。

``` java
ServerSocket(int port, int backlog)
```

+ 使用指定的端口、侦听 backlog 和要绑定到的本地 IP 地址创建服务器。

``` java
ServerSocket(int port, int backlog, InetAddress bindAddr)
```

## 常用方法

|方法名  |  作用描述|
|---| ---|
|Socket	accept() | 侦听并接受到此套接字的连接 |
|void bind(SocketAddress endpoint) | 将 ServerSocket 绑定到特定地址（IP 地址和端口号） |
|void bind(SocketAddress endpoint, int backlog) | 将 ServerSocket 绑定到特定地址（IP 地址和端口号）|
|void close() | 关闭此套接字|
|ServerSocketChannel getChannel() | 返回与此套接字关联的唯一 ServerSocketChannel 对象（如果有）|
|InetAddress getInetAddress() | 返回此服务器套接字的本地地址|
|int getLocalPort() | 返回此套接字在其上侦听的端口 |
|SocketAddress getLocalSocketAddress() | 返回此套接字绑定的端点的地址，如果尚未绑定则返回 null |
|int getReceiveBufferSize() | 获取此 ServerSocket 的 SO_RCVBUF 选项的值，该值是将用于从此 ServerSocket 接受的套接字的建议缓冲区大小|
|boolean getReuseAddress() | 测试是否启用 SO_REUSEADDR|
|int getSoTimeout() | 获取 SO_TIMEOUT 的设置|
|protected  void implAccept(Socket s) | ServerSocket 的子类使用此方法重写 accept() 以返回它们自己的套接字子类|
|boolean isBound() | 返回 ServerSocket 的绑定状态|
|boolean isClosed() | 返回 ServerSocket 的关闭状态 |
|void setPerformancePreferences(int connectionTime, int latency, int bandwidth) | 设置此 ServerSocket 的性能首选项|
|void setReceiveBufferSize(int size) | 为从此 ServerSocket 接受的套接字的 SO_RCVBUF 选项设置默认建议值、
|void setReuseAddress(boolean on) | 启用/禁用 SO_REUSEADDR 套接字选项 |
|static void setSocketFactory(SocketImplFactory fac) | 为应用程序设置服务器套接字实现工厂|
|void setSoTimeout(int timeout) | 通过指定超时值启用/禁用 SO_TIMEOUT，以毫秒为单位 |
|String toString() | 作为 String 返回此套接字的实现地址和实现端口|

## 服务端示例

``` java
public class SocketServer {

    public static void main(String[] args) {
        int port = genPort(args);

        ServerSocket server = null;
        //创建执行线程池
        ExecutorService service = Executors.newFixedThreadPool(50);

        try{
            //通过制定端口 创建ServerSocket
            server = new ServerSocket(port);
            System.out.println("启动服务！");

            while(true){
                //等待连接
                Socket socket = server.accept();

                //执行连接Socket
                service.execute(new Handler(socket));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭资源
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }

    static class Handler implements Runnable{

        Socket socket = null;

        public Handler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;
            try{
                //初始化Socket 通信的输入流 默认编码UTF-8
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), "UTF-8"));

                //初始化Socket 通信的输出流 默认编码UTF-8
                writer = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

                String readMessage = null;
                while(true){
                    System.out.println("服务器读取通信信息...");
                    if((readMessage = reader.readLine()) == null){
                        break;
                    }
                    System.out.println(readMessage);
                    writer.println("服务器接受信息：" + readMessage);
                    writer.flush();
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

    //获取初始化端口 默认为9999
    private static int genPort(String[] args){
        if(args.length > 0){
            try{
                return Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                return 9999;
            }
        }else{
            return 9999;
        }
    }

}
```
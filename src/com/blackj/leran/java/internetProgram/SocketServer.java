package com.blackj.leran.java.internetProgram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Program Name: java-basic
 * <p>
 * Description: Socket 服务端示例
 * <p>
 * Created by Zhang.Haixin on 2018/11/8
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
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

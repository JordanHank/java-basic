package com.blackj.leran.java.internetProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Program Name: java-basic
 * <p>
 * Description: Socket 客户端示例
 * <p>
 * Created by Zhang.Haixin on 2018/11/8
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
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

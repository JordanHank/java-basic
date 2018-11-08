package com.blackj.leran.java.internetProgram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Program Name: java-basic
 * <p>
 * Description: DatagramSocket UDP服务端
 * <p>
 * Created by Zhang.Haixin on 2018/11/8
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class DatagramSocketServer {

    public static void main(String [] args) {
        //指定服务器接受端口
        int port = genPort(args);

        //指定包传输端口号
        int packetPort = genPacketPort(args);

        try {
            //指定端口创建 DatagramSocket 服务端
            DatagramSocket server = new DatagramSocket(port);

            //指定UDP传输包大小
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            server.receive(packet);
            System.out.println(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet
                    .getData()));

            //指定数据包传递内容
            String content = "你好客户端！";
            packet.setData(content.getBytes());

            packet.setPort(packetPort);
            //指定包传输地址为本地地址
            packet.setAddress(InetAddress.getLocalHost());

            //发送数据包
            server.send(packet);

            //关闭服务器
            server.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //获取初始化端口 默认为5060
    private static int genPort(String[] args){
        if(args.length > 0){
            try{
                return Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                return 5060;
            }
        }else{
            return 5060;
        }
    }

    //指定数据包传输端口
    private static int genPacketPort(String[] args){
        if(args.length > 1){
            try{
                return Integer.parseInt(args[1]);
            }catch(NumberFormatException e){
                return 5070;
            }
        }else{
            return 5070;
        }
    }
}

package com.lgli.socetclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPClient
 *
 * @author lgli
 * @since 2020/5/4 10:58
 * @since 1.0
 */
public class UDPClient {

    public static void main(String[] args) throws Exception{
        String data = "你好，客户端";
        DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getByName("localhost"),8081);
        DatagramSocket datagramSocket = new DatagramSocket();
        while(true){
            datagramSocket.send(datagramPacket);
            System.out.println("客户端2发送了数据.....");
        }

    }


}

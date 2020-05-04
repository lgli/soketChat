package com.lgli.socketservice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDPService
 *
 * @author lgli
 * @since 2020/5/4 19:35
 * @since 1.0
 */
public class UDPService {

    private static final int port = 8081;

    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(port);
        //预先执行获取打包数据
        byte [] receive = new byte[2048];
        DatagramPacket datagramPacket = new DatagramPacket(receive,receive.length);
        datagramSocket.receive(datagramPacket);
        System.out.println("服务端接收到来自"+datagramPacket.getAddress()+":"+datagramPacket.getPort()+"的数据："+datagramPacket.getData());
    }




}

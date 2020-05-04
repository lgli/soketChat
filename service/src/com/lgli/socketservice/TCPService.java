package com.lgli.socketservice;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCPService
 * 基于TCP协议的socket服务端
 * @author lgli
 * @since 1.0
 */
public class TCPService {

    /**
     * 监听端口
     */
    private static final int port = 8080;


    public static void main(String[] args) throws Exception{
        //循环监听，监听有连接，则放入线程，让线程去实现方法
        ServerSocket serverSocket = new ServerSocket(port);
        while(true){
            System.out.println("等待客户端等待连接......");
            //获取到一个socket连接
            final Socket socket = serverSocket.accept();
            //获取Runnable对象
            Runnable runnable = ()->{
                try{
                    InetAddress inetAddress = socket.getInetAddress();
                    int port = socket.getPort();
                    String clientName = inetAddress+":"+port;
                    System.out.println("服务端获取到了客户端的一个连接......"+clientName);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    while(true){
                        //持续监听获取输入的数据
                        String result  = reader.readLine();
                        System.out.println("客户端("+clientName+"):"+result);
                        //服务端回复数据
                        Scanner scanner = new Scanner(System.in);
                        String next = scanner.next();
                        writer.write(next);
                        writer.newLine();
                        writer.flush();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            };
            //启动新的线程去执行这个会话操作
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }


}

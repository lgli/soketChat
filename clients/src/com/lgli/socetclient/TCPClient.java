package com.lgli.socetclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCPClient
 * 客户端发送请求连接
 * @author lgli
 * @since 1.0
 */
public class TCPClient {
    public static void main(String[] args) throws Exception{
        System.out.println("开始连接localhost服务端......");
        Socket socket = new Socket("localhost",8080);
        System.out.println("连接localhost服务端成功......");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while(true){
            //持续输入数据
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            writer.write(next);
            writer.newLine();
            writer.flush();
            //读取服务端发送的数据
            String s = reader.readLine();
            System.out.println("服务端："+s);
        }
    }
}

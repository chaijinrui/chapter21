package com.hspedu.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * FileName：SocketTCP03Server
 * Author: thinkbook-chaijinrui
 * Date: 2023/9/27
 * Time: 22:54
 * Description：要求使用字符流
 */
public class SocketTCP03Server {
    @Test
    public void testSocketTCP03Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("链接成功~");
        Socket accept = serverSocket.accept();
        System.out.println("客户端已连接，IP地址：" + accept.getInetAddress().getHostAddress());


//        InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s=bufferedReader.readLine();
        System.out.println("收到的消息："+s);

        OutputStream outputStream = accept.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("helloc,clint");
        bufferedWriter.flush();
        accept.shutdownOutput();

//关闭流

        bufferedWriter.close();
        bufferedReader.close();
        serverSocket.close();
        accept.close();


    }
}

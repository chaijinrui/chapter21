package com.hspedu.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * FileName：SocketTCP01Server
 * Author: sns-chaijinrui
 * Date: 2023/9/27
 * Time: 16:18
 * Description：服务端
 */
public class SocketTCP01Server {
    @Test
    public void test() throws IOException {
//        1. 在本机999端口监听，等待链接(要求9999没有被占用）
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待监听中......");
//         2. 如果有客户端连接，则会返回Socket对象
        Socket accept = serverSocket.accept();
        System.out.println("服务端与客户端链接成功~");
        System.out.println("客户端已连接，IP地址：" + accept.getInetAddress().getHostAddress());
//        3. 通过Socket.getinputStream, 读取客户端写入到数据通道的数据
        InputStream inputStream = accept.getInputStream();
//        4. IO读取
        byte[] bytes = new byte[1024];
        int line = 0;
        while ((line = inputStream.read(bytes)) != -1) {
            System.out.println("line= " + line);
//            根据读取到的实际长度显示内容  将字节数据转成字符串
            System.out.println(new String(bytes, 0, line));
        }
//        通过输出流输出
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hello,server".getBytes());
        //        设置写入结束标记
        accept.shutdownOutput();

//        关闭流和Socket
        inputStream.close();
        outputStream.close();
        accept.close();
        serverSocket.close();
    }
}

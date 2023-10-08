package com.hspedu.socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * FileName：SocketTCP03Client
 * Author: thinkbook-chaijinrui
 * Date: 2023/9/27
 * Time: 22:53
 * Description：要求是使用字符流
 */
public class SocketTCP03Client {
    @Test
    public void testSocketTCP03Client() throws IOException {
        //        链接服务器--链接如下机器的9999端口，如果链接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接成功");
//        客户端发送数据给服务端
//        得到和这个Socket对象关联的输出流对象
//        socker独有的getoutputStream
//        字节流转字符流转缓冲流  更高效
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello, 字符流服务端~");

//        如果使用字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();

//        结束标记
        socket.shutdownOutput();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("收到的消息：" + bufferedReader.readLine());

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端已退出~");
    }
}

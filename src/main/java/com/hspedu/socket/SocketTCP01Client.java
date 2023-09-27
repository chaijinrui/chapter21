package com.hspedu.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * FileName：SocketTCP01Client
 * Author: sns-chaijinrui
 * Date: 2023/9/27
 * Time: 16:25
 * Description：客户端
 */
public class SocketTCP01Client {
    @Test
    public void test() throws IOException {
//        链接服务器--链接如下机器的9999端口，如果链接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接成功");
//        客户端发送数据给服务端
//        得到和这个Socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello.server".getBytes());
//        关闭流对象和Socket
        outputStream.close();
        socket.close();
        System.out.println("客户端已退出~");
    }
}

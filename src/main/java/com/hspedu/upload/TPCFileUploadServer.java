package com.hspedu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * FileName：TPCFileUploadServer
 * Author: thinkbook-chaijinrui
 * Date: 2023/10/2
 * Time: 15:01
 * Description：文件上传的服务端
 */
public class TPCFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        System.out.println("客户端和服务器已连接~");
//      读取客户端发送数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
//      将byts数组写入到文件
        String copyPath = "src\\qier2.png";
        BufferedOutputStream buffOutputStream = new BufferedOutputStream(new FileOutputStream(copyPath));
        buffOutputStream.write(bytes);
        buffOutputStream.flush();
        accept.shutdownOutput();//设置一个写入结束的标记

//      关闭流
        bufferedInputStream.close();
        buffOutputStream.close();
        accept.close();

    }
}

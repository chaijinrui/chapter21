package com.hspedu.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * FileName：TPCFileUploadclient
 * Author: thinkbook-chaijinrui
 * Date: 2023/10/2
 * Time: 15:02
 * Description：文件上传的客户端
 */
public class TPCFileUploadclient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
//        将图片转化为字节数组
        String FilePath = "E:\\java基础学习资料\\资料\\分享资料\\qq1.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(FilePath)));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
//      将bytes数据发送给服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);//将文件的内容写入到数据通道
        bufferedOutputStream.flush();
        socket.shutdownOutput();//设置写入结束标记

//      关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();

    }
}

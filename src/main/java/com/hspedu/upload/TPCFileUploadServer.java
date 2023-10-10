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
        System.out.println("开始写入");
        String copyPath = "H:\\CJR-QA\\qq2.png";
        BufferedOutputStream buffOutputStream = new BufferedOutputStream(new FileOutputStream(copyPath));
        buffOutputStream.write(bytes);
        System.out.println("写入完成");
//        向客户端发送信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();//把内容刷新一下到数据通道

        accept.shutdownOutput();//设置写入结束关闭



//      关闭流
        bufferedWriter.close();
        bufferedInputStream.close();
        buffOutputStream.close();
        accept.close();

    }
}

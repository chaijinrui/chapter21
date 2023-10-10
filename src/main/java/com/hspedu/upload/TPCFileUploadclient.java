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
        String FilePath = "H:\\CJR-QA\\qq1.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(FilePath)));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);//调用自己写的方法 把文件内容转将为字节数组
//      将bytes数据发送给服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());//把getout输出流转为bufferedOutputStream输出流
        bufferedOutputStream.write(bytes);//将文件的内容写入到数据通道
        socket.shutdownOutput();//设置写入结束标记
//        接收服务端信息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        inputStream.close();
//      关闭流
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();


    }
}

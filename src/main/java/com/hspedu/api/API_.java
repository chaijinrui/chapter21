package com.hspedu.api;

import org.junit.Test;

import java.net.InetAddress;

/**
 * FileName：API_
 * Author: sns-chaijinrui
 * Date: 2023/9/27
 * Time: 15:09
 * Description：演示InetAddress类具体使用
 */
public class API_ {
    @Test
    public void testInetAddress() throws Exception {
//        获取本机的inetAddress对象--计算机名称+IP地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //        根据指定主机名获取inetAddress对象--计算机名称+IP地址
        InetAddress allByName = InetAddress.getByName("CJR-SNS");
        System.out.println(allByName);

        //    根据域名获取inetAddress对象
//        获取www.baidu.com
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

//        通过inetAddress对象，获取对应地址
        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);

//        通过对象，获取域名
        String hostName = byName.getHostName();
        System.out.println(hostName);
    }
}

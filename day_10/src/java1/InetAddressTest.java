package java1;

/**
 * @Author: Leo messi
 * @Date: 2022/07/17/10:56
 * @Description:
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中有两个主要的问题：
 * 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：网络通信协议：TCP/IP参考模型
 *
 * 三、通信要素一：IP和端口号
 * 1.IP：唯一的标识Internet上的计算机（通信实体）
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类：IPv4 和 IPv6;
 * 4.域名：www.baidu.com www.mi.com www.sina.com
 * 5.本地回路地址：127.0.0.1  对应着localhost
 * 6.如何实例化InetAddress两个方法：getByName(),getLocalHost
 *      两个常用方法：getHostName，getHostAddress
 *
 * 7.端口号：正在计算机上运行的进程
 *  不同的进程有不同的端口号
 *  被规定为一个 16 位的整数 0~65535。
 *
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket。
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");

            //获取本机的ip
            InetAddress inet4 = InetAddress.getLocalHost();

            //getHostName()
            System.out.println("inet2.getHostName() = " + inet2.getHostName());
            //getHostAddress
            System.out.println("inet2.getHostAddress() = " + inet2.getHostAddress());

            System.out.println(inet1);
            System.out.println("inet2 = " + inet2);
            System.out.println("inet3 = " + inet3);
            System.out.println("inet4 = " + inet4);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

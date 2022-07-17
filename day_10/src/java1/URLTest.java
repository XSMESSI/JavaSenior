package java1;

/**
 * @Author: Leo messi
 * @Date: 2022/07/17/17:50
 * @Description:
 */

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 * http://124.223.201.235:8080/examples/a.txt
 * 协议   主机名           端口   资源地址          参数列表
 */
public class URLTest {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://124.223.201.235:8080/examples/a.txt");
        System.out.println("url.getProtocol() = " + url.getProtocol());
        //public String getProtocol( ) 获取该URL的协议名
        System.out.println("url.getHost() = " + url.getHost());
        //public String getHost( ) 获取该URL的主机名
        System.out.println("url.getPort() = " + url.getPort());
        //public String getPort( ) 获取该URL的端口号
        System.out.println("url.getPath() = " + url.getPath());
        //public String getPath( ) 获取该URL的文件路径
        System.out.println("url.getFile() = " + url.getFile());
        //public String getFile( ) 获取该URL的文件名
        System.out.println("url.getQuery() = " + url.getQuery());
        //public String getQuery( ) 获取该URL的查询名
    }
}

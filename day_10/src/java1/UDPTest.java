package java1;

/**
 * @Author: Leo messi
 * @Date: 2022/07/17/17:38
 * @Description:
 */

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP协议的网络编程
 *
 */
public class UDPTest {

    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP发送方式的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,1023);
        socket.send(packet);

        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket =  new DatagramSocket(1023);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);

        System.out.println("new String(packet.getData(),0, packet.getLength()) = " + new String(packet.getData(), 0, packet.getLength()));


        socket.close();

    }
}

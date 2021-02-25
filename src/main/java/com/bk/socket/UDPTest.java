package com.bk.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Create by bear
 * Date 2021/2/24 3:40 下午
 */
public class UDPTest {
    @Test
    void send() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "你好，我是xxx";
            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, address, 9990);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    @Test
    void receive() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9990);
            byte[] buf = new byte[100];
            DatagramPacket packet = new DatagramPacket(buf, 0, buf.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}

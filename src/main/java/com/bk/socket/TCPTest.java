package com.bk.socket;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create by bear
 * Date 2021/2/21 10:16 下午
 */
public class TCPTest {
    @Test
    void testClient() {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 1. 创建Socket对象指明服务端ip地址和端口号
            InetAddress address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address, 4569);
            // 2. 获取一个OutputStream对象
            os = socket.getOutputStream();
            // 3. 写出字节数据
            os.write("你好，我是哥哥，你是妹妹吗？".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    void testServer() {
        ServerSocket sso = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bbo = null;
        try {
            // 1. 创建ServerSocket
            sso = new ServerSocket(4569);
            // 2. 通过accpet方法获取一个Socket
            socket = sso.accept();
            // 3. 获取InputStream流用于读入操作
            is = socket.getInputStream();
            // 4. 创建ByteArrayOutputStream用于存储读入的字节数组
            bbo = new ByteArrayOutputStream();
            byte[] buff = new byte[20];
            int len;
            while ((len = is.read(buff)) != -1) {
                bbo.write(buff, 0, len);
            }
            System.out.println("收到来自:"+socket.getInetAddress().getHostAddress()+"的信息："+bbo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            if (bbo != null) {
                try {
                    bbo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sso != null) {
                try {
                    sso.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

package com.bk.socket;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create by bear
 * Date 2021/2/22 11:11 下午
 */
public class TCPTest3 {
    /**
     * 客户端发送文件到服务端
     */
    @Test
    void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8970);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("input.png")));
            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1) {
                os.write(buff, 0, len);
            }

            // 需要收到告知服务端传输结束
            socket.shutdownOutput();
            //等待接受服务端的通知
            InputStream is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buff2 = new byte[20];
            int len2;
            while ((len2 = is.read(buff2)) != -1) {
                baos.write(buff2, 0, len2);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
    void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(8970);
            socket = serverSocket.accept();
            System.out.println("文件传输开始");
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(new File("server_output.png")));
            byte[] buff = new byte[1024];
            int len;
            while ((len = is.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            System.out.println("文件传输结束");

            // 返回通知信息给客户端
            os = socket.getOutputStream();
            os.write("你好，你的文件我已收到".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

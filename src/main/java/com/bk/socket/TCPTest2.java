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
public class TCPTest2 {
    /**
     * 客户端发送文件到服务端
     */
    @Test
    void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8970);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("input.png")));
            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

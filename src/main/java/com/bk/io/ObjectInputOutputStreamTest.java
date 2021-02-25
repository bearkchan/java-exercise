package com.bk.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Create by bear
 * Date 2021/2/21 3:17 下午
 */
public class ObjectInputOutputStreamTest {
    @Test
    void testObjectOutputStream() {
        ObjectOutputStream oss = null;
        try {
            FileOutputStream fos = new FileOutputStream("object.serial");
            oss = new ObjectOutputStream(fos);
            oss.writeObject(new String("hello world!"));
            oss.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oss != null) {
                try {
                    oss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream("object.serial");
            ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            String str = (String) object;
            System.out.println("str = " + str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

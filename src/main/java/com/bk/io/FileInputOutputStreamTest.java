package com.bk.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Create by bear
 * Date 2021/2/9 5:13 下午
 */
public class FileInputOutputStreamTest {

    @Test
    void testInputStreamReaderAndWriter() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcImg = new File("input.png");
            File desImg = new File("out.png");
            fis = new FileInputStream(srcImg);
            fos = new FileOutputStream(desImg);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

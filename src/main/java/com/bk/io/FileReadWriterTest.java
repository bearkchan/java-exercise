package com.bk.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create by bear
 * Date 2021/2/6 1:38 下午
 */
public class FileReadWriterTest {
    @Test
    void testFileReader1() {
        FileReader fr = null;
        // try-catch快捷键：option+cmd+t
        try {
            // 1. 创建file对象
            File file = new File("hello.txt");
            // 2. 创建节点流
            fr = new FileReader(file);

            // 3. 读取文件流
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭文件流
            try {
                // 记得添加if判断其是否为null
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void testFileReader2() {
        File file = new File("hello1.txt");
        FileWriter fw = null;
        try {
            // FileWriter构造器分类：
            // 1. 覆盖写入：FileWriter(file) / FileWriter(file,false)
            // 2. 追加写入：FileWriter(file, true)
            //fw = new FileWriter(file);
            fw = new FileWriter(file, true);
            fw.write("hello world!\n");
            fw.write("nice to meet you.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 文本文件的读写
     */
    @Test
    void testFileReaderAndWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello1.txt");
            File desFile = new File("hello2.txt");
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

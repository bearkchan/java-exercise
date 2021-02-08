package com.bk.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * Create by bear
 * Date 2021/2/2 11:27 上午
 */
public class FileTest {
    @Test
    void test01() throws IOException {
        File dir = new File("fileDir");
        if (!dir.exists()) {
            boolean mkdir = dir.mkdir();
            new File(dir, "file1").createNewFile();
            new File(dir, "file2").createNewFile();
            new File(dir, "file3").createNewFile();
            new File(dir, "dir1").mkdir();
            new File(dir, "dir2").mkdir();
            new File(dir, "dir3").mkdir();
        }

        boolean dir2 = removeFile(dir, "dir2");
        System.out.println("dir2 = " + dir2);
    }

    public boolean removeFile(File parentDir, String fileName) {
        File file = new File(parentDir, fileName);
        if (file.exists()) {
            boolean delete = file.delete();
            return delete;
        }
        return false;
    }


    @Test
    void test2() {
        File dir = new File("fileDir");
        String[] list = dir.list();
        for (String s : list) {
            boolean b = s.endsWith(".jpg");
            if (b){
                System.out.println("s = " + s);
            }
        }
    }
}

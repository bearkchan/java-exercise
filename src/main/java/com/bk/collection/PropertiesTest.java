package com.bk.collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Create by bear
 * Date 2021/1/23 11:06 上午
 */
public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("source.properties");
            Properties properties = new Properties();
            properties.load(fis);
            String name = properties.getProperty("name");
            String age = properties.getProperty("age");
            Integer ageInt = Integer.parseInt(age);
            System.out.println("name = " + name);
            System.out.println("ageInt = " + ageInt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.bk.string;

import org.junit.jupiter.api.Test;

/**
 * Create by bear
 * Date 2020/12/30 7:35 下午
 */
public class StringTest {
    @Test
    public void test01() {
        String s1 = "hello";
        String s2 = "hello";
        // 比较s1和s2的地址值
        System.out.println(s1 == s2);//true

        String s3 = "abc";
        s3 += "def";
        String s4 = new String("abcdef");
        System.out.println(s3 == s4);//false

    }

    @Test
    void test02() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s1 + s2;
        String s4 = "abcabc";
        System.out.println(s3 == s4);//false
    }
}

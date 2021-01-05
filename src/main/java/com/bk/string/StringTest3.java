package com.bk.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Create by bear
 * Date 2020/12/30 9:13 下午
 */
public class StringTest3 {

    /**
     * 对字符串中字符进行自然顺序排序
     * 提示：
     * 1）字符串变成字符数组。
     * 2）对数组排序，选择，冒泡，Arrays.sort();
     * 3）将排序后的数组变成字符串。
     */
    @Test
    void test05() {
        String str = "kA2dgD2x13";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = String.valueOf(chars);
        System.out.println("str = " + str);
    }

    /**
     * 获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef“;
     * str2 = "cvhellobnm";
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    @Test
    void test04() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

        String max, min;
        max = str1.length() > str2.length() ? str1 : str2;
        min = max == str1 ? str2 : str1;

        outer:
        for (int i = 0; i < min.length(); i++) {
            for (int start = 0, end = min.length() - i; end <= min.length(); start++, end++) {
                String temp = min.substring(start, end);
                if (max.contains(temp)) {
                    System.out.println(temp);
                    break outer;
                }
            }
        }
    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
     */
    @Test
    void test03() {
        int count = 0;
        String str = "abkkcadkabkebfkabkskab";
        String searchStr = "ab";
        int nextIndex = 0;
        //while (true) {
        //    int nextIndex = str.indexOf("ab");
        //    if (nextIndex < 0) {
        //        break;
        //    }
        //    count += 1;
        //    // 要记得加上查询的字符的长度
        //    str = str.substring(nextIndex + "ab".length());
        //}

        // 方式2
        while ((nextIndex = str.indexOf(searchStr, nextIndex)) != -1) {
            count += 1;
            nextIndex += searchStr.length();
        }
        System.out.println("count = " + count);
    }

    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反 转为”abfedcg”
     */
    @Test
    void test02() {
        String str = "abcdefg";
        int start = 2;
        int end = 6;
        // 左闭右开的原则
        String subStr = str.substring(start, end);
        System.out.println("subStr = " + subStr);
        char[] chars = subStr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char rep = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = rep;
        }
        String repStr = new String(chars);
        str = str.replace(subStr, repStr);
        System.out.println("str = " + str);
    }

    /**
     * 模拟一个trim方法，去除字符串两端的空格。
     */
    @Test
    public void test01() {
        String s1 = " ";
        String s2 = s1.trim();
        System.out.println("s2 =" + s2 + "*****");

        String s3 = " ";
        System.out.println("**********" + myTrim(s3) + "***************");
    }


    public static String myTrim(String str) {
        if (str != null) {
            if (str.isEmpty()) {
                return "";
            }

            int start = 0;
            int end = str.length() - 1;

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }

            if (str.charAt(start) == ' ') {
                return "";
            }
            return str.substring(start, end + 1);
        }
        return null;
    }
}

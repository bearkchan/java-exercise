package com.bk.string.exer;

import org.junit.jupiter.api.Test;

/**
 * Create by bear
 * Date 2021/1/2 4:29 下午
 */
public class StringReverseExer {

    /**
     * 方式一
     *
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public String reverse01(String str, int startIndex, int endIndex) {
        str = str.trim();
        if (str != null) {
            char[] chars = str.toCharArray();
            for (int i = startIndex, y = endIndex; i < y; i++, y--) {
                char temp = chars[i];
                chars[i] = chars[y];
                chars[y] = temp;
            }
            return new String(chars);
        }
        return null;
    }


    /**
     * 使用StringBuilder
     *
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public String reverse02(String str, int startIndex, int endIndex) {
        str = str.trim();
        if (str != null) {
            // step1：首先根据str的长度创建StringBuilder
            StringBuilder sb = new StringBuilder(str.length());
            // step2：拼接前面部分
            sb.append(str.substring(0, startIndex));
            // step3：拼接中间部分
            //for (int i = startIndex; i <= endIndex; i++) {
            //    sb.append(str.charAt(i));
            //}
            sb.append(new StringBuilder(str.substring(startIndex,endIndex+1)).reverse());


            // step4：拼接后面部分
            sb.append(str.substring(endIndex + 1));

            // 返回String字符串
            return sb.toString();
        }
        return null;
    }


    @Test
    public void test() {
        String str = "abcdefg";
        System.out.println(reverse01(str, 2, 5));
        System.out.println(reverse02(str, 2, 5));
    }
}

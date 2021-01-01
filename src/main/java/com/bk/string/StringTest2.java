package com.bk.string;

/**
 * Create by bear
 * Date 2020/12/30 7:50 下午
 */
public class StringTest2 {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        //str = "test ok";
        ch[0] = 'b';
        ch = new char[]{'a', 'b', 'c', 'd'};
    }

    public static void main(String[] args) {
        StringTest2 ex = new StringTest2();
        ex.change(ex.str, ex.ch);
        System.out.println("ex.str = " + ex.str);
        System.out.println(ex.ch);
    }
}

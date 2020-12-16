package com.bk.object;

import org.junit.jupiter.api.Test;

public class WrapperTest {


    /**
     * 基本数据类型、包装类型--->
     * 1. String类型：使用String.valueOf()方法进行转换
     * 2. 直接在后面加上+连接符
     */
    @Test
    public void test1() {
        int num1 = 123;
        // 方法1
        String str1 = String.valueOf(num1);
        System.out.println("str1 = " + str1);
        // 方法2
        String str2 = num1 + "";
        System.out.println("str2 = " + str2);


        // boolean类型转换
        Boolean bo1 = false;
        String str3 = String.valueOf(bo1);
        System.out.println("str3 = " + str3);

    }


    /**
     * String类型------>基本数据类型、包装类：使用包装类的.parseXxx(String)
     */
    @Test
    void test2() {
        String str1 = "123";
        int num1 = Integer.parseInt(str1);
        System.out.println("num1 = " + num1);

        String str2 = "true";
        boolean bo1 = Boolean.parseBoolean(str2);
        System.out.println("bo1 = " + bo1);
    }


    /**
     * 包装类面试题1：
     */
    @Test
    void test3() {
        Object obj1 = true ? new Integer(1) : new Double(2);
        // obj1 = 1.0
        // ⭐️Tips: 三元运算符要求条件1和条件2的类型一致，因此obj1自动变成Double包装类，则结果变成double类型1.0
        // 类型提升
        System.out.println("obj1 = " + obj1);

        Object obj2 = new Integer(1);
        // obj2 = 1
        System.out.println("obj2 = " + obj2);

        Object obj3 = false ? 2 : "1比较大";
        System.out.println("obj3 = " + obj3);
    }

    @Test
    void test4() {
        Integer i1 = new Integer(1);
        Integer j1 = new Integer(1);
        System.out.println("i1==j1: " + (i1 == j1)); //false


        // ⭐️Tips：Integer内部结构中定义了IntegerCache内部类，创建了Integer[]数组，保存了-128~127范围内整数
        // 如果我们使用自动装箱的方式赋值，在-128~127范围之内的数，可以直接使用数组中的元素，不用再去new了
        // 目的：提高效率。
        Integer i2 = 1;
        Integer j2 = 1;
        System.out.println("i2==j2: " + (i2 == j2)); // true

        // 128超出了IntegerCache的范围，因此相当于new Integer(128)
        Integer i3 = 128;
        Integer j3 = 128;
        System.out.println("i3==j3: " + (i3 == j3)); // false
    }
}

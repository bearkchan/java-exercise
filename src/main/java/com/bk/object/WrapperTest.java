package com.bk.object;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Vector;

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


    /**
     * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出 最高分，并输出学生成绩等级。
     *  提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的 长度。而向量类java.util.Vector可以根据需要动态伸缩。
     *  创建Vector对象：Vector v=new Vector();
     *  给向量添加元素：v.addElement(Object obj); //obj必须是对象
     *  取出向量中的元素：Object obj=v.elementAt(0);
     * 注意第一个元素的下标是0，返回值是Object类型的。
     * 计算向量的长度：v.size();
     * 若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等
     */
    @Test
    void scoreTest() {
        // 1. 创建scanner对象
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> vector = new Vector<>();
        // 2. for(;;)循环获取成绩输入
        int maxScore = 0;
        for (;;){
            System.out.println("请输入学生成绩（负数代表结束）");
            int score = scanner.nextInt();
            // 2.1 如果为负数，则跳出循环
            if (score<0){
                break;
            }
            // 2.2 如果RR分数大于100分，则重新输入成绩
            if (score>100){
                System.out.println("成绩输入错误，请重新输入（0-100）");
                continue;
            }
            // 3. 获取最大成绩
            if (maxScore<score){
                maxScore = score;
            }

            // 添加到vector数组中
            vector.addElement(score);
        }
        // 4. 循环遍历数组，判断等级并输出
        char level;
        for (int i = 0; i < vector.size(); i++) {
            Integer score = vector.elementAt(i);
            int gapScore = maxScore-score;
            if (gapScore<10){
                level = 'A';
            }else if (gapScore<20){
                level = 'B';
            }else if (gapScore<30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("Student-"+(i+1)+" : score is "+score+" ; level is "+level);
        }
    }
}

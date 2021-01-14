package com.bk.enum1;

import com.sun.tools.javah.Gen;

/**
 * Create by bear
 * Date 2021/1/6 8:57 上午
 */
public class EnumTest {
    public static void main(String[] args) {
        Gender female = Gender.FEMALE;
        System.out.println("female = " + female);

        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println("value = " + value);
        }
    }
}


enum Gender {
    // 1. 定义实例变量,多个对象用逗号隔开，最后一个用封号结尾；
    MALE("男"),
    FEMALE("女");

    //成员变量
    String genderName;

    // 3. 定义成员变量的public get()方法
    public String getGenderName() {
        return genderName;
    }

    // 4. 私有化有参构造器
    Gender(String genderName) {
        this.genderName = genderName;
    }


    // 5. 重写toString方法
    @Override
    public String toString() {
        return "Gender{" +
                "genderName='" + genderName + '\'' +
                '}';
    }
}
//class Gender {
//    // 1. private final成员变量
//    private final String genderName;
//
//    // 2. 定义成员变量的public get()方法
//    public String getGenderName() {
//        return genderName;
//    }
//
//    // 3. 私有化有参构造器
//    private Gender(String genderName) {
//        this.genderName = genderName;
//    }
//
//    // 4. 定义public static final实例变量
//    public static final Gender MALE = new Gender("男");
//    public static final Gender FEMALE = new Gender("女");
//
//    // 5. 重写toString方法
//    @Override
//    public String toString() {
//        return "Gender{" +
//                "genderName='" + genderName + '\'' +
//                '}';
//    }
//}

//class Season {
//
//    private final String SEASONNAME;//季节的名称
//    private final String SEASONDESC;//季节的描述
//
//    private Season(String seasonName, String seasonDesc) {
//        this.SEASONNAME = seasonName;
//        this.SEASONDESC = seasonDesc;
//    }
//
//    public static final Season SPRING = new Season("春天", "春暖花开");
//    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
//    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
//    public static final Season WINTER = new Season("冬天", "白雪皑皑");
//
//}
//
enum Season {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "白雪皑皑");

    String SEASONNAME;//季节的名称
    String SEASONDESC;//季节的描述


    private Season(String seasonName, String seasonDesc) {
        this.SEASONNAME = seasonName;
        this.SEASONDESC = seasonDesc;
    }

}

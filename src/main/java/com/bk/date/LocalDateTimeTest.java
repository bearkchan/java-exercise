package com.bk.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Create by bear
 * Date 2021/1/7 2:28 下午
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 通过now实例化LocalDateTime对象
        LocalDateTime lof = LocalDateTime.now(); //2021-01-09T12:45:03.496
        // 通过of实例化LocalDateTime对象
        //LocalDateTime of = LocalDateTime.of(2021, 1,6, 23, 24,55);

        // getXxx获取属性值
        System.out.println(lof.getDayOfMonth()); //9
        System.out.println(lof.getDayOfWeek());  //SATURDAY
        System.out.println(lof.getDayOfYear());  //9

        // withXxx设置属性
        System.out.println(lof.withDayOfMonth(1)); //2021-01-01T12:43:51.577

        // plus添加属性
        System.out.println(lof.plusDays(20)); //2021-01-29T12:44:24.521

        // minus减少属性值
        System.out.println(lof.minusDays(2)); //2021-01-07T12:45:03.496
    }
}

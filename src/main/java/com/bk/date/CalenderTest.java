package com.bk.date;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Create by bear
 * Date 2021/1/4 11:58 下午
 */
public class CalenderTest {
    @Test
    void test01(){
        Calendar calendar = Calendar.getInstance();
        // get方法
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("dayOfMonth = " + dayOfMonth);
        // set方法
        calendar.set(Calendar.DAY_OF_MONTH,29);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("dayOfMonth = " + dayOfMonth);
        // add方法
        calendar.add(Calendar.DAY_OF_MONTH,-4);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("dayOfMonth = " + dayOfMonth);
        // getTime():日历类--->Date类
        Date date = calendar.getTime();
        System.out.println("date = " + date);
        // setTime():Date类---->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("dayOfMonth = " + dayOfMonth);
    }
}

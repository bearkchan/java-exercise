package com.bk.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by bear
 * Date 2021/1/4 11:35 下午
 */
public class SimpleDateFormatTest {
    @Test
    public void test01() {
        // 创建SimpleDateFormat实例，构造器参数为日期样式pattern
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        // 使用格式化将日期转换为字符串
        String format = sdf.format(date);
        System.out.println("format = " + format);

        // 使用解析将字符串解析长日期Date格式，解析格式必须和构造器参数格式一致，否则就会报错java.text.ParseException
        try {
            Date parse = sdf.parse("2019-01-12 23:45:23");
            System.out.println("parse = " + parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习题：将字符串"2020-01-02"转换成java.sql.Date类型
     */
    @Test
    void test02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-01-02");
        java.sql.Date mysqlDate = new java.sql.Date(date.getTime());
        System.out.println("mysqlDate = " + mysqlDate);
    }


    /**
     * "三天打鱼两天晒网"，计算从1990-01-01开始算起，2020-03-12日是在打鱼还是在晒网
     * @throws ParseException
     */
    @Test
    void test03() throws ParseException {
        String startTime = "1990-01-01";
        String endTime = "2020-03-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        long distancemill = endDate.getTime() - startDate.getTime();
        System.out.println("distancemill = " + distancemill);
        System.out.println((1000 * 60 * 60 * 24));
        long days = distancemill / (1000 * 60 * 60 * 24);
        System.out.println("days = " + days);
        System.out.println("days%5 = " + days % 5);
    }
}

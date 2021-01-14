package com.bk.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Create by bear
 * Date 2021/1/9 1:30 下午
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dtf.format(LocalDate.now());
        System.out.println("format = " + format);
        TemporalAccessor parse = dtf.parse("2021-01-02");
        LocalDate localDate = LocalDate.from(parse);
        System.out.println("localDate = " + localDate);
    }
}

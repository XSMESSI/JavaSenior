package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Author: Leo messi
 * @Date: 2022/06/12/23:04
 * @Description: jdk8 中日期时间API的测试
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020 - 1900,9 - 1,8);
        System.out.println("date1 = " + date1);//Tue Sep 08 00:00:00 CST 2020
    }

    /**
     * LocalDate，LocalTime,LocalDateTime的使用
     * 说明:
     *      1.LocalDateTime相较于LocalDate，LocalTime，使用的频率要高
     *      2.类似于Calendar
     *
     */
    @Test
    public void test1(){
        //now() 获取当前的日期，时间 日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
        System.out.println("localDateTime = " + localDateTime);

        //of()
        LocalDateTime time = LocalDateTime.of(2020, 10, 6, 10, 2, 3);
        System.out.println("time = " + time);

        //getXX()
        System.out.println("localDate.getDayOfMonth() = " + localDate.getDayOfMonth());
        System.out.println("localDateTime.getDayOfWeek() = " + localDateTime.getDayOfWeek());
        System.out.println("localDateTime.getMonth() = " + localDateTime.getMonth());
        System.out.println("localDateTime.getMonthValue() = " + localDateTime.getMonthValue());
        System.out.println("localDateTime.getMinute() = " + localDateTime.getMinute());

        //  体现了不可变性
        //with() 设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println("localDate = " + localDate);
        System.out.println("localDate1 = " + localDate1);

        LocalDateTime localDateTime1 = localDateTime.withHour(4);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("localDateTime1 = " + localDateTime1);

        //不可变性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("localDateTime2 = " + localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.minusDays(6);
        System.out.println("localDateTime3 = " + localDateTime3);
    }

    /** Instant的使用
     * 类似于java。util.Date
     *
     * */
    @Test
    public void test2(){
        //now() 获取本初子午线对应的时间
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);
        //获取对应的毫秒数 1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println("milli = " + milli);

        //ofEpochMilli : 通过给定毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1655162446679L);
        System.out.println("instant1 = " + instant1);
    }

    /***
     * DateTimeFormatter:格式化或解析日期，时间
     * 类似于SimpleDateFormat
     */
    @Test
    public void test3(){

         //*  预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期- 》字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String strt1 = formatter.format(localDateTime);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("strt1 = " + strt1);
        //解析 ： 字符串 ->日期
        TemporalAccessor parse = formatter.parse("2022-06-14T07:28:49.965");
        System.out.println("parse = " + parse);

        //  本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG),FormatStyle.SHORT
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println("str2 = " + str2);//22-6-14 上午7:34

        //ofLocalizedDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println("str3 = " + str3);//2022年6月14日 星期二

        //  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println("str4 = " + str4);

        //解析
        TemporalAccessor acc = formatter3.parse("2022-02-18 03:52:56");
        System.out.println("acc = " + acc);

    }
}

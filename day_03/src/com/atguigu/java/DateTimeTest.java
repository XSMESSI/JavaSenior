package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/06/05/14:34
 * @Description:
 */

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 */
public class DateTimeTest {

    /**
     * java.util.Date类
     *          java.sql.Date
     * 1.两个构造器的使用
     *      构造器一：Date():创建一个对应的当前时间的Date()对象
     *      构造器二：创建指定毫秒数的Date对象
     *
     *
     * 2.两个方法的使用
     *        >toString() ：显示当前的年月日时分秒
     *        getTime :后期当前Date对象对应的恩毫秒数。（时间戳）
     *  3.java.sql.Date 对应着数据库中的日期类型的变量
     *      >如何实例化
     *      >如何将util.Date对象转换为sql.Date对象
     *
     *
     *
     */

    @Test
    public void test2(){
        //构造器一：Date():创建一个对应的当前时间的Date()对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1651311018299L);
        System.out.println(date2.toString());

        //创建sql对象
        java.sql.Date date3 = new java.sql.Date(1311411038299L);
        System.out.println(date3);

        //如何将util.Date对象转换为sql.Date对象
        //情况一：
//        Date dete4 = new java.sql.Date(1311411038299L);
//        java.sql.Date date5 = (java.sql.Date) dete4;

        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);
    }


    //1.System类中的 currentTimeMillis()
   @Test
   public void test1(){
       long time = System.currentTimeMillis();
       //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
       //称为时间戳
       System.out.println(time);
   }
}

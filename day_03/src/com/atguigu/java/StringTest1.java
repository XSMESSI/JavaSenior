package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/06/05/11:02
 * @Description:
 */

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {




    /**
     * String与byte[] 之间的转换
     * 编码：String -->byte[]   :调用String 的getBytes()
     * 解码：byte[]  -》String：调用String的构造器
     *
     *String -->byte[]:调用String的getBytes()
     *
     * 编码：字符串-->字节  （看的懂 -->看不懂  的二进制数据）
     * 解码：编码的逆过程,字节  -->字符串 (看不懂的二进制数据  --> 看的懂)
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行转换
        System.out.println("bytes.ro = " + Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("****************");
        String str2 = new String(bytes);//使用默认字符集，进行解码
        System.out.println("str2 = " + str2);

        String str3 = new String(gbks);
        System.out.println("str3 = " + str3);//出现乱码，原因：编码集和解码集不一致!

        String str4 = new String(gbks, "gbk");
        System.out.println("str4 = " + str4);
    }



    /**
     * String 与char[] 之间的转换
     * String --》cahr[]  ：调用String的charArray()
     * char[] --》String :调用String的构造器
     */

    @Test
    public void test2(){
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println("chars[i] = " + chars[i]);
        }

        char[] chars1 = new char[]{'h','e','l','l','o'};
        String str2 = new String(chars1);
        System.out.println("s = " + str2);
    }


    /**
     * 复习：
     * String 与基本数据类型,包装类之间的转换
     *
     *
     * String --》基本数据类型,包装类：调用包装类的静态方法parseXxx(str)
     * 基本数据类型,包装类型  -》String:调用Strign 重载的valueOf()方法
     */

    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println("num = " + num);

        String s = String.valueOf(num);
        String s1 = num + "";
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
    }
}

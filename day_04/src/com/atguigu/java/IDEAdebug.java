package com.atguigu.java;

import org.junit.Test;

/**
 * @Author: Leo messi
 * @Date: 2022/06/12/12:59
 * @Description:
 */
public class IDEAdebug {

    @Test
    public void testDebug(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//

        System.out.println(sb);//

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
}

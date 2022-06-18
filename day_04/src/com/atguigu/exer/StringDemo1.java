package com.atguigu.exer;

import org.junit.Test;

/**
 * @Author: Leo messi
 * @Date: 2022/06/12/9:25
 * @Description:
 */
public class StringDemo1 {
    /**
     * 获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
     *
     *
     */

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){
        int count = 0;
        int index = 0;
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if (mainLength >= subLength){
            //方式1：
//            while ((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }

            //改进：
            while ((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }
            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String maintr = "abkkcadkabkebfkabkskab";
        String sunStr = "ab";
        int count = getCount(maintr,sunStr);
        System.out.println("count = " + count);
    }
}

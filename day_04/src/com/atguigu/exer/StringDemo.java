package com.atguigu.exer;

import org.junit.Test;

/**
 * @Author: Leo messi
 * @Date: 2022/06/12/8:49
 * @Description:
 */
public class StringDemo {


    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
     * 方式一：转换为数组cahr[]
     *
     */
    public String reverse(String str,int startIndex,int endIndex){
        if (str != null && str != ""){
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y;x++,y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String的拼接操作
    public String reverse1(String str,int startIndex,int endIndex){
        if (str != null && str != ""){
            //第一部分
            String reverseStr = str.substring(0,startIndex);
            //第二部分
            for (int i = endIndex;i >= startIndex;i--){
                reverseStr += str.charAt(i);
            }
            //第3部分
            reverseStr += str.substring(endIndex+1);
            return reverseStr;
        }
        return null;

    }

    //方式3：使用StirgnBuffer/StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex){
        if (str != null && str != ""){
            StringBuilder builder = new StringBuilder(str.length());

            //第一部分：
            builder.append(str.substring(0,startIndex));
            //第2部分
            for (int i = endIndex;i >= startIndex;i--){
                builder.append(str.charAt(i));
            }
            //第3部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;

    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
//        String reverse = reverse(str, 2, 5);
//        String reverse1 = reverse(str, 2, 5);
//        String reverse2 = reverse(str, 2, 5);
//        String reverse = reverse1(str, 2, 5);
        String reverse = reverse2(str, 2, 5);
        System.out.println("reverse = " + reverse);
    }
}

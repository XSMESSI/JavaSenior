package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: Leo messi
 * @Date: 2022/06/25/14:42
 * @Description: jdk5.0 新增了foreach循环，用于遍历数组，集合
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));

        //for(集合元素的类型 局部变量 ： 集合对象 )
        //内部仍然调用迭代器
        for (Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for (数组元素 局部变量 ： 数组对象)
        for (int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","JJ"};

        //方式一：普通for赋值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for (String s : arr){
            s = "GG";
        }

        for (int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}

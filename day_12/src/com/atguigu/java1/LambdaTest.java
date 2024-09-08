package com.atguigu.java1;

import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/6 15:39
 * @desc <> Lambda表达式的使用实例
 */
public class LambdaTest {

    @Test
    public void test() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        System.out.println("*********************");
        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();

    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int comapre1 = com1.compare(1, 2);

        System.out.println(comapre1);

        System.out.println("*********************");

        //Lambda表达式的简化写法
        Comparator<Integer> com4 = (o1, o2) -> Integer.compare(o1, o2);

        int comapre4 = com1.compare(1, 2);

        System.out.println(comapre4);

        System.out.println("*********************");

        //方法引用
        Comparator<Integer> com2 = Integer::compare;

        int comapre2 = com2.compare(13, 2);

        System.out.println(comapre2);

    }
}

package com.atguigu.exer;

/**
 * @Author: Leo messi
 * @Date: 2022/05/29/0:23
 * @Description:
 */

/**
 * 练习
 * 创建两个分线程，其中一个线程遍历100以内的偶数，另一个遍历100以内的奇数
 *
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 thread1 = new MyThread1();
//        MyThread2 thread2 = new MyThread2();
//
//        thread1.start();
//        thread2.start();
        //创建Thread类的匿名方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
           if (i % 2 != 0){
               System.out.println(Thread.currentThread().getName() + ":" + i);
           }
        }
    }
}

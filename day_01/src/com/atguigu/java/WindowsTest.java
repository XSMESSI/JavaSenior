package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/05/29/2:14
 * @Description:
 */

/**
 * 创建三个窗口买票，总票数为100张，使用继承Thread类的方式
 *
 *
 * 存在线程安全问题，待解决
 *
 */

class Window extends Thread{

    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

public class WindowsTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();

    }
}

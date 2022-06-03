package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/05/30/22:47
 * @Description:  使用同步方法解决实现Runable接口的线程安全
 */

/**
 * 关于同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
 * 2.非静态的同步方法，同步监视器是：this
 *  静态的同步方法，同步监视器是：当前类本身
 */

class Window3 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
            }
        }

        private synchronized void show(){//同步监视器：this
//        synchronized (this){
            if (ticket > 0 ){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票：票号为：" + ticket);
                ticket--;
            }
//        }
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window1 = new Window3();
        Thread thread1 = new Thread(window1);
        Thread thread2 = new Thread(window1);
        Thread thread3 = new Thread(window1);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}




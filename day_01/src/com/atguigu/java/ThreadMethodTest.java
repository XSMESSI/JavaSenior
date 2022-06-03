package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/05/29/0:55
 * @Description:
 */

/**
 * 测试Thread中常用的方法:
 * 1.start():启动当前线程,调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建恩线程要执行的操作声明在此方法中
 * 3.currentThread()：静态方法，返回当前代码执行的线程
 * 4.getName():获取当前现成的恩名字
 * 5.setName();设置当前线程的名字
 * 6.yield() ：释放当前CPU的执行权
 * 7.join()：在线程A中调用线程B的join()方法，此时线程a就进入阻塞状态，知道线程b完全执行完以后
 *          线程b才结束阻塞状态
 * 8.stop()：已过时，当执行此方法时，强制结束当前线程
 * 9.sleep()：让当前线程睡眠指定到milltime毫秒，在指定的恩milltime毫秒时间内，当前线程是阻塞状态
 * 10.isAlive()：判断当前线程是否存活
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5
 * 2.如何获取和设置当前线程的优先级
 * getPriority():获取线程的优先级
 * setPriority(int p);设置
 *  高优先级的线程要抢占低优先级线程cpu的执行权，但是只是从概率上讲，高优先级的线程高概率的情况下被执行
 *  并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 */

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
//                try {
////                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+">>>>>>>>>"+ i);
            }

//            if (i % 20 == 0){
//                yield();
//            }
        }
    }


    public HelloThread(String name){
        super(name);
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
//        h1.setName("线程1");
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+">>>>>>>>"+ i);
            }

//            if (i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }


        System.out.println(h1.isAlive());
    }
}

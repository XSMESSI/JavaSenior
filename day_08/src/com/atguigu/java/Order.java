package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Leo messi
 * @Date: 2022/07/03/15:10
 * @Description:
 */
public class Order<T> {

    String orderName;
    int orderId;


    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
        //编译不通过
//        T[] rr = new T[10];

        T[] arr =(T[]) new Object[10];
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    //如下三个方式都不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    //静态方法中不能使用类的泛型
//    public static void show(T orderT){
//        System.out.println("orderT = " + orderT);
//    }

    public void show(){
        //编译不通过
//        try {
//
//        }catch (T t){
//
//        }
    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非在实例化类时确定。

    public static <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}

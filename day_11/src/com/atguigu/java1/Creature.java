package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/2 14:48
 * @desc <>
 */
public class Creature<T> implements Serializable {

    private char gender;

    public double weight;

    private void breath(){
        System.out.println("呼吸...");
    }

    public void eat(){
        System.out.println("吃东西...");
    }
}

package com.atguigu.java;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/1 15:27
 * @desc <>
 */
public class Person {

    private String name;

    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    private Person(String name) {
        this.name = name;
    }
    public  void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        return "我的国籍是：" + nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}

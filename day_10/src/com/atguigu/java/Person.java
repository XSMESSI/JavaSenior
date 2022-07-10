package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/07/10/9:51
 * @Description:
 */

import java.io.Serializable;

/**
 * Person需要满足如下的需求，方可序列化
 * 1.需要实现接口Serializable
 * 2.需要当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性，也必须是可序列化的，（默认情况再，基本数据类型时可序列化的）
 *
 *
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 * 饰的成员变量
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 422331111112L;

    private String name;
    private transient int age;
    private int id;
    private Account account;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable{
    public static final long serialVersionUID = 122331111112L;

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Account() {
    }

    public Account(double salary) {
        this.salary = salary;
    }
}

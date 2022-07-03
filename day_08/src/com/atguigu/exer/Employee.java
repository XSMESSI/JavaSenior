package com.atguigu.exer;

/**
 * @Author: Leo messi
 * @Date: 2022/06/27/21:57
 * @Description:
 */

/**
 * 定义一个 Employee 类。
 * 该类包含：private 成员变量 name,age,birthday，其中 birthday 为
 * MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthda
 */
public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private MyDate birthday;

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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

//    //没有指明泛型时写法
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee e = (Employee) o;
//            return this.name.compareTo(e.getName());
//        }
////        return 0;
//        throw new RuntimeException("传入的数据类型不一致");
//    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}

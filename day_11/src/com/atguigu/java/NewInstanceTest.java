package com.atguigu.java;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/2 8:28
 * @desc 通过反射创建对应运行时类的对象
 */
public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        /**
         * newInstance()：调用此方法，创建对应的运行时类的对象，并返回该对象。
         * 内部调用了运行时类的空参构造器，如果该类没有空参构造器，则会抛出InstantiationException异常。
         *
         * 要想此方法正常的创建运行时类的对象，要求：
         * 1.运行时类必须提供空参的构造器；
         * 2.空参的构造器的访问权限得够，通常，设置为public。
         *
         在javabean中要求提供一个public的空参构造器。原因：
         1.便于通过反射，创建运行时类的对象;
         2.便于子类继承此运行类时，默认使用super()时，保证父类有此构造器。
         */
        Person obj = clazz.newInstance();
        System.out.println("obj = " + obj);

    }

    //体会反射的动态性
    @Test
    public void test2(){

        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            System.out.println("num = " + num);

            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println("obj = " + obj);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }


    /**
     * 创建一个指定类的对象
     * classPath：类的全路径名【指定类的全类名】
     * @param classPath
     * @return
     * @throws ClassNotFoundException
     */
    public Object getInstance(String classPath) throws ClassNotFoundException {
        Class clazz = Class.forName(classPath);
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/2 14:59
 * @desc 获取当前运行时类的属性结构
 */
public class FieldTest {

    @Test
    public void test1(){
        Class clazz = Person.class;

        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("--------");

        //getDeclaredFields()：获取当前运行时类中声明的所有属性，包括public、private、protected、默认（包）访问权限的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }


    //权限修饰符  数据类型 变量名 = 。。。
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type + "\t");
            //3.变量名

            String fName = f.getName();
            System.out.print(fName + "\t");

            System.out.println("--------");
        }
    }
}

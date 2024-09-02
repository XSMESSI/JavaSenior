package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/3 6:48
 * @desc <>
 */
public class OtherTest {

    /**
     * 获取构造器结构
     */
    @Test
    public void test1(){

        Class clazz = Person.class;
        //getConstructors() 获取当时运行类中的所有构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println("构造器：" + c);
        }

        System.out.println();
        //getDeclaredConstructors() 获取当时运行类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println("构造器：" + c);
        }
    }

    /**
     * 获取运行时类的父类
     */

    @Test
    public void test2(){
        Class clazz = Person.class;
        //getSuperclass() 获取运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println("父类：" + superclass);
    }

    /**
     * 获取运行时的带泛型的父类
     */

    @Test
    public void test3(){
        Class clazz = Person.class;
        //getGenericSuperclass() 获取运行时类的带泛型的父类
        Type superclass = clazz.getGenericSuperclass();
        System.out.println("父类：" + superclass);
    }

    /**
     * 获取运行时的带泛型的父类的泛型
     *
     * 代码：逻辑性代码 vs 功能性代码
     */

    @Test
    public void test4(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type type : actualTypeArguments) {
            System.out.println("泛型：" + type);
            System.out.println("类型：" + type.getClass());
            System.out.println(type.getTypeName());
        }
    }

    /**
     * 获取运行时类实现的接口
     *
     * */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("接口：" + c);
        }

        System.out.println("--------");
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class aClass : interfaces1) {
            System.out.println("父类接口：" + aClass);
        }
    }


    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class clazz = Person.class;

        Package aPackage = clazz.getPackage();
        System.out.println("包：" + aPackage);

    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test7(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}

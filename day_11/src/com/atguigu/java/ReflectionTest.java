package com.atguigu.java;

import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/1 15:39
 * @desc <>
 */
public class ReflectionTest {


    //反射之前，对于Person的操作
    @Test
    public  void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("leo", 20);

        //2.通过对象,调用其内部的属性，方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部的私有结构
        //比如:name,showNation()以及私有的构造器

    }

    //反射之后，对于Person的操作
    @Test
    public  void test2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("leo", 20);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性，方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println("p = " + p);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构的，比如：私有的构造器，私有的属性，私有的方法

        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("leo");
        System.out.println("p1 = " + p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "xushen");
        System.out.println("p1 = " + p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");//相当于p1.showNation("中国");
        System.out.println("nation = " + nation);
    }

    //疑问1？通过直接new的方式或者反射的方式都可以调用公用的结构，开发中到底用哪个？
    //建议：直接new的方式
    //什么时候会使用？反射的方式。反射的特征：动态性。
    //疑问2？反射的机制与面向对象中的封装性是不是矛盾的？如何看待这两个技术?
    //不矛盾。


    /*
    关于java.lang.Class类的理解:
    * 1:类加载的过程
    程序经过java.exe命令以后，会生成一个或者多个字节码文件(.class结尾),接着我们使用java.exe命令对某个
    字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就成为类的加载过程。加载到内存中的类，我们就称为运行时类
    此运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应一个运行时类
    3.加载到内存中运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类。
    * */
    //获取Class的实例的方式（前3种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：调用运行时类的对象()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //方式四：使用类的加载器：ClassLoader.loadClass(String classPath)【了解】
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);
    }



    //万事万物皆对象？对象.xxx,File,URL,反射,前端,数据库的操作

    //Class实例可以是哪些结构的说明：
    @Test
    public  void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;


        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
// 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}

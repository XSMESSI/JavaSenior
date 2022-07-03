package com.atguigu.java2;

/**
 * @Author: Leo messi
 * @Date: 2022/07/03/20:37
 * @Description:
 */

import org.junit.Test;

import java.util.*;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 *
 */
public class GenericTest {

    /**
     * 1.泛型在继承方面的体现
     *
     * 虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系
     * 补充：类A是类B的父类 ,A<G> B<G>
     */
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        //编译不通过
        //        Date date = new Date();
//        str = date;


        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
//        list1 = list2;

        /**
         * 反证法：
         * 假设list1 = list2;
         * list1.add(123);导致混入非String的数据，出错;
         *
         */
        show(list1);
        show1(list2);


    }
    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }


    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        ArrayList<String> list2 = null;
        List<String> list3 = null;
        list1 = list2;
        list3 = list2;
    }

    /**
     * 2.通配符的使用
     * 通配符：？
     * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类时G<?>
     */
    @Test
    public void ttes4(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

//        print(list1);
//        print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("AA1");
        list3.add("AA2");
        list = list3;
        //添加(就是一个写入的过程):对于List<?>就不能向其内部添加数据了。
        //除了添加null之外
//        list.add("aa");
//        list.add("?");

        list.add(null);

        //获取（读取）:允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println("o = " + o);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }
    }

    /**
     * 3.有限制条件的通配符的使用
     * ？ extends A :
     *              G<？ extends A>可以作为G<A> 和G<B>的父类的，其中B 是A 的子类
     * ? super A:
     *              G<? super A>可以作为G<A> 和G<B>的父类的，其中B 是A 的父类类
     * 
     * 
     */

    @Test
    public void tets4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        
        
        //读取数据:
        list1 = list4;
        Person person = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);
        list2 = list4;
        Object obj = list2.get(0);

        //写入数据:
        //编译不通过
//        list1.add(new Student());
        list2.add(new Person());

        //编译通过：
        list2.add(new Person());
        list2.add(new Student());
    }
}
